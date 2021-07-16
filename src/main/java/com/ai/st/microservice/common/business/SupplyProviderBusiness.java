package com.ai.st.microservice.common.business;

import com.ai.st.microservice.common.clients.ProviderFeignClient;
import com.ai.st.microservice.common.dto.providers.MicroserviceProviderDto;
import com.ai.st.microservice.common.dto.providers.MicroserviceProviderRoleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class SupplyProviderBusiness {

    private final Logger log = LoggerFactory.getLogger(SupplyProviderBusiness.class);

    @Autowired
    private ProviderFeignClient providerClient;

    public MicroserviceProviderDto getProviderById(Long providerId) {
        MicroserviceProviderDto providerDto = null;
        try {
            providerDto = providerClient.findById(providerId);
        } catch (Exception e) {
            log.error("No se podido consultar el proveedor: " + e.getMessage());
        }
        return providerDto;
    }

    public MicroserviceProviderDto getProviderByUserTechnical(Long userCode) {
        MicroserviceProviderDto providerDto = null;
        try {
            providerDto = providerClient.findByUserCode(userCode);
        } catch (Exception e) {
            log.error("No se ha podido consultar el proveedor: " + e.getMessage());
        }
        return providerDto;
    }

    public MicroserviceProviderDto getProviderByUserAdministrator(Long userCode) {
        MicroserviceProviderDto providerDto = null;
        try {
            providerDto = providerClient.findProviderByAdministrator(userCode);
        } catch (Exception e) {
            log.error("No se ha podido consultar el proveedor: " + e.getMessage());
        }
        return providerDto;
    }

    public MicroserviceProviderDto getProviderByUserTechnicalOrAdministrator(Long userCode) {
        MicroserviceProviderDto providerDtoByAdministrator = getProviderByUserAdministrator(userCode);
        MicroserviceProviderDto providerDtoByTechnical = getProviderByUserTechnical(userCode);
        if (providerDtoByAdministrator != null) {
            return providerDtoByAdministrator;
        }
        return providerDtoByTechnical;
    }

    public boolean userProviderIsDirector(Long userCode) {
        try {
            List<MicroserviceProviderRoleDto> providerRoles = providerClient.findRolesByUser(userCode);
            MicroserviceProviderRoleDto roleDirector = providerRoles.stream()
                    .filter(roleDto -> roleDto.getId().equals(RoleBusiness.SUB_ROLE_DIRECTOR_PROVIDER)).findAny()
                    .orElse(null);
            if (roleDirector != null) {
                return true;
            }
        } catch (Exception e) {
            log.error("No se ha podido verificar si el usuario es un director(proveedor): " + e.getMessage());
        }
        return false;
    }

    public boolean userProviderIsDelegate(Long userCode) {
        try {
            List<MicroserviceProviderRoleDto> providerRoles = providerClient.findRolesByUser(userCode);
            MicroserviceProviderRoleDto roleDirector = providerRoles.stream()
                    .filter(roleDto -> roleDto.getId().equals(RoleBusiness.SUB_ROLE_DELEGATE_PROVIDER)).findAny()
                    .orElse(null);
            if (roleDirector != null) {
                return true;
            }
        } catch (Exception e) {
            log.error("No se ha podido verificar si el usuario es un delegado(proveedor): " + e.getMessage());
        }
        return false;
    }

}
