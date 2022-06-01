package com.ai.st.microservice.common.dto.providers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MicroserviceProviderAdministratorDto implements Serializable {

    private static final long serialVersionUID = -4177372978182201398L;

    private Long userCode;
    private List<MicroserviceProviderRoleDto> roles;

    public MicroserviceProviderAdministratorDto() {
        this.roles = new ArrayList<MicroserviceProviderRoleDto>();
    }

    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public List<MicroserviceProviderRoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<MicroserviceProviderRoleDto> roles) {
        this.roles = roles;
    }

}
