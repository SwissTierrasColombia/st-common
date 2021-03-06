package com.ai.st.microservice.common.business;

import com.ai.st.microservice.common.clients.UserFeignClient;
import com.ai.st.microservice.common.dto.administration.MicroserviceRoleDto;
import com.ai.st.microservice.common.dto.administration.MicroserviceUserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdministrationBusiness {

    private final Logger log = LoggerFactory.getLogger(AdministrationBusiness.class);

    @Autowired
    private UserFeignClient userClient;

    public MicroserviceUserDto getUserById(Long userId) {
        MicroserviceUserDto userDto = null;
        try {
            userDto = userClient.findById(userId);
        } catch (Exception e) {
            log.info("Error consultando el usuario I: " + e.getMessage());
        }
        return userDto;
    }

    public MicroserviceUserDto getUserByToken(String headerAuthorization) {
        MicroserviceUserDto userDto = null;
        try {
            String token = headerAuthorization.replace("Bearer ", "").trim();
            userDto = userClient.findByToken(token);

        } catch (Exception e) {
            log.error("Error consultando el usuario: " + e.getMessage());
        }
        return userDto;
    }

    public boolean isManager(MicroserviceUserDto userDto) {
        MicroserviceRoleDto roleManager = userDto.getRoles().stream()
                .filter(roleDto -> roleDto.getId().equals(RoleBusiness.ROLE_MANAGER)).findAny().orElse(null);

        return roleManager != null;
    }

    public boolean isAdministrator(MicroserviceUserDto userDto) {

        MicroserviceRoleDto roleAdministrator = userDto.getRoles().stream()
                .filter(roleDto -> roleDto.getId().equals(RoleBusiness.ROLE_ADMINISTRATOR)).findAny().orElse(null);

        return roleAdministrator != null;
    }

}
