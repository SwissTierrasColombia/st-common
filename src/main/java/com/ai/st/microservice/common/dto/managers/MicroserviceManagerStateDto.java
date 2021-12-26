package com.ai.st.microservice.common.dto.managers;

import java.io.Serializable;

public class MicroserviceManagerStateDto implements Serializable {

    private static final long serialVersionUID = -1174020453923999718L;

    private Long id;
    private String name;

    public MicroserviceManagerStateDto() {

    }

    public MicroserviceManagerStateDto(Long id, String name) {
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
