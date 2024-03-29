package com.ai.st.microservice.common.dto.supplies;

import java.io.Serializable;

public class MicroserviceSupplyAttachmentTypeDto implements Serializable {

    private static final long serialVersionUID = 5501241816417835256L;

    private Long id;
    private String name;

    public MicroserviceSupplyAttachmentTypeDto() {

    }

    public MicroserviceSupplyAttachmentTypeDto(Long id, String name) {
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
