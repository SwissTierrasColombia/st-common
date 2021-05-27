package com.ai.st.microservice.common.dto.supplies;

import java.io.Serializable;

public class MicroserviceCreateSupplyOwnerDto implements Serializable {

    private static final long serialVersionUID = 8812016046556072388L;

    private String ownerType;
    private Long ownerCode;

    public MicroserviceCreateSupplyOwnerDto() {

    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }

    public Long getOwnerCode() {
        return ownerCode;
    }

    public void setOwnerCode(Long ownerCode) {
        this.ownerCode = ownerCode;
    }

}
