package com.ai.st.microservice.common.dto.workspaces;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MicroserviceWorkspaceDto implements Serializable {

    private static final long serialVersionUID = 3626653639569669214L;

    private Long id;
    private Boolean isActive;
    private Date createdAt;
    private Date updatedAt;
    private List<MicroserviceWorkspaceOperatorDto> operators;
    private List<MicroserviceWorkspaceManagerDto> managers;
    private MicroserviceMunicipalityDto municipality;

    public MicroserviceWorkspaceDto() {
        operators = new ArrayList<MicroserviceWorkspaceOperatorDto>();
        managers = new ArrayList<MicroserviceWorkspaceManagerDto>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public List<MicroserviceWorkspaceOperatorDto> getOperators() {
        return operators;
    }

    public void setOperators(List<MicroserviceWorkspaceOperatorDto> operators) {
        this.operators = operators;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public MicroserviceMunicipalityDto getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MicroserviceMunicipalityDto municipality) {
        this.municipality = municipality;
    }

    public List<MicroserviceWorkspaceManagerDto> getManagers() {
        return managers;
    }

    public void setManagers(List<MicroserviceWorkspaceManagerDto> managers) {
        this.managers = managers;
    }

}
