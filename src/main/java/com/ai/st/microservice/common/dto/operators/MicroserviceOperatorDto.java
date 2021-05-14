package com.ai.st.microservice.common.dto.operators;

import java.io.Serializable;
import java.util.Date;

public class MicroserviceOperatorDto implements Serializable {

    private static final long serialVersionUID = 4784320463657739097L;

    private Long id;
    private String name;
    private String taxIdentificationNumber;
    private Date createdAt;
    private Boolean isPublic;
    private String alias;
    private MicroserviceOperatorStateDto operatorState;

    public MicroserviceOperatorDto() {

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

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public MicroserviceOperatorStateDto getOperatorState() {
        return operatorState;
    }

    public void setOperatorState(MicroserviceOperatorStateDto operatorState) {
        this.operatorState = operatorState;
    }
}
