package com.ai.st.microservice.common.dto.tasks;

import java.io.Serializable;

public class MicroserviceTaskStepDto implements Serializable {

    private static final long serialVersionUID = 927981596792722859L;

    private Long id;
    private String code;
    private String description;
    private Boolean status;
    private MicroserviceTaskTypeStepDto typeStep;

    public MicroserviceTaskStepDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public MicroserviceTaskTypeStepDto getTypeStep() {
        return typeStep;
    }

    public void setTypeStep(MicroserviceTaskTypeStepDto typeStep) {
        this.typeStep = typeStep;
    }

}
