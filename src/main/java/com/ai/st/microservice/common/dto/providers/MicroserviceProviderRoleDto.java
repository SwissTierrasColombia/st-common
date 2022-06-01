package com.ai.st.microservice.common.dto.providers;

import java.io.Serializable;

public class MicroserviceProviderRoleDto implements Serializable {

    private static final long serialVersionUID = -8478165185005520773L;

    private Long id;
    private String name;

    public MicroserviceProviderRoleDto() {

    }

    public MicroserviceProviderRoleDto(Long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
