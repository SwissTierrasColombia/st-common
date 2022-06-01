package com.ai.st.microservice.common.business;

import com.ai.st.microservice.common.clients.OperatorFeignClient;
import com.ai.st.microservice.common.dto.operators.MicroserviceOperatorDto;
import com.ai.st.microservice.common.dto.operators.MicroserviceOperatorUserDto;
import com.ai.st.microservice.common.services.SCMTracing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperatorBusiness {

    private final Logger log = LoggerFactory.getLogger(OperatorBusiness.class);

    @Autowired
    private OperatorFeignClient operatorClient;

    public MicroserviceOperatorDto getOperatorById(Long operatorId) {
        MicroserviceOperatorDto operatorDto = null;
        try {
            operatorDto = operatorClient.findById(operatorId);
        } catch (Exception e) {
            String messageError = String.format("Error consultando el operador %d: %s", operatorId, e.getMessage());
            SCMTracing.sendError(messageError);
            log.error(messageError);
        }
        return operatorDto;
    }

    public List<MicroserviceOperatorUserDto> getUsersByOperator(Long operatorId) {
        List<MicroserviceOperatorUserDto> users = new ArrayList<>();
        try {
            users = operatorClient.getUsersByOperator(operatorId);
        } catch (Exception e) {
            String messageError = String.format("Error consultando los usuarios del operador %d: %s", operatorId,
                    e.getMessage());
            SCMTracing.sendError(messageError);
            log.error(messageError);
        }
        return users;
    }

    public MicroserviceOperatorDto getOperatorByUserCode(Long userCode) {
        MicroserviceOperatorDto operatorDto;
        try {
            operatorDto = operatorClient.findByUserCode(userCode);
        } catch (Exception e) {
            String messageError = String.format("Error consultando el operador a partir del usuario %d: %s", userCode,
                    e.getMessage());
            SCMTracing.sendError(messageError);
            log.error(messageError);
            return null;
        }
        return operatorDto;
    }

}
