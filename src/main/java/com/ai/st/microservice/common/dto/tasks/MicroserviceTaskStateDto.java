package com.ai.st.microservice.common.dto.tasks;

import java.io.Serializable;

public class MicroserviceTaskStateDto implements Serializable {

    private static final long serialVersionUID = 1648940408334070826L;

    private Long id;
    private String name;

    public MicroserviceTaskStateDto() {

    }

    public MicroserviceTaskStateDto(Long id, String name) {
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
