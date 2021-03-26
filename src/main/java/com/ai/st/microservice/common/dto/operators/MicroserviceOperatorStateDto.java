package com.ai.st.microservice.common.dto.operators;

import java.io.Serializable;

public class MicroserviceOperatorStateDto implements Serializable {

    private static final long serialVersionUID = 844681853006719507L;

    private Long id;
    private String name;

    public MicroserviceOperatorStateDto() {

    }

    public MicroserviceOperatorStateDto(Long id, String name) {
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
