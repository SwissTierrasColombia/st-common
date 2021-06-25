package com.ai.st.microservice.common.dto.tasks;

import java.io.Serializable;

public class MicroserviceTaskCategoryDto implements Serializable {

    private static final long serialVersionUID = 7237234886460619822L;

    private Long id;
    private String name;

    public MicroserviceTaskCategoryDto() {

    }

    public MicroserviceTaskCategoryDto(Long id, String name) {
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
