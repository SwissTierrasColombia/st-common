package com.ai.st.microservice.common.dto.providers;

import java.io.Serializable;

public class MicroserviceCreateProviderProfileDto implements Serializable {

    private static final long serialVersionUID = 6515735489433109151L;

    private String name;
    private String description;

    public MicroserviceCreateProviderProfileDto() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
