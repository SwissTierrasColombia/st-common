package com.ai.st.microservice.common.dto.supplies;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MicroserviceSupplyDto implements Serializable {

    private static final long serialVersionUID = 8259586718340595896L;

    private Long id;
    private Date createdAt;
    private MicroserviceSupplyStateDto state;
    private String municipalityCode;
    private String name;
    private String observations;
    private Long typeSupplyCode;
    private Long requestCode;
    private Long managerCode;
    private String modelVersion;
    private List<MicroserviceSupplyOwnerDto> owners;
    private List<MicroserviceSupplyAttachmentDto> attachments;
    private Boolean isValid;

    public MicroserviceSupplyDto() {
        this.owners = new ArrayList<>();
        this.attachments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public MicroserviceSupplyStateDto getState() {
        return state;
    }

    public void setState(MicroserviceSupplyStateDto state) {
        this.state = state;
    }

    public String getMunicipalityCode() {
        return municipalityCode;
    }

    public void setMunicipalityCode(String municipalityCode) {
        this.municipalityCode = municipalityCode;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Long getTypeSupplyCode() {
        return typeSupplyCode;
    }

    public void setTypeSupplyCode(Long typeSupplyCode) {
        this.typeSupplyCode = typeSupplyCode;
    }

    public List<MicroserviceSupplyOwnerDto> getOwners() {
        return owners;
    }

    public void setOwners(List<MicroserviceSupplyOwnerDto> owners) {
        this.owners = owners;
    }

    public List<MicroserviceSupplyAttachmentDto> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<MicroserviceSupplyAttachmentDto> attachments) {
        this.attachments = attachments;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(Long managerCode) {
        this.managerCode = managerCode;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Long getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(Long requestCode) {
        this.requestCode = requestCode;
    }

}
