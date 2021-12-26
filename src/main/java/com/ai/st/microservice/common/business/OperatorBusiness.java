package com.ai.st.microservice.common.business;


import com.ai.st.microservice.common.clients.OperatorFeignClient;
import com.ai.st.microservice.common.dto.operators.MicroserviceOperatorDto;
import com.ai.st.microservice.common.dto.operators.MicroserviceOperatorUserDto;
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
            log.error("Error consultando operador: " + e.getMessage());
        }
        return operatorDto;
    }

    public List<MicroserviceOperatorUserDto> getUsersByOperator(Long operatorId) {
        List<MicroserviceOperatorUserDto> users = new ArrayList<>();
        try {
            users = operatorClient.getUsersByOperator(operatorId);
        } catch (Exception e) {
            log.error("Error consultando usuarios por operador: " + e.getMessage());
        }
        return users;
    }


    public MicroserviceOperatorDto getOperatorByUserCode(Long userCode) {
        MicroserviceOperatorDto operatorDto;
        try {
            operatorDto = operatorClient.findByUserCode(userCode);
        } catch (Exception e) {
            log.error("Error consultando operador: " + e.getMessage());
            return null;
        }
        return operatorDto;
    }

}
