package com.ai.st.microservice.common.dto.workspaces;

import com.ai.st.microservice.common.dto.managers.MicroserviceManagerDto;
import com.ai.st.microservice.common.dto.operators.MicroserviceOperatorDto;

import java.io.Serializable;
import java.util.Date;

public class MicroserviceWorkspaceOperatorDto implements Serializable {

    private static final long serialVersionUID = -1943824478121434815L;

    private Long id;
    private Date createdAt;
    private Date startDate;
    private Date endDate;
    private Long numberParcelsExpected;
    private Double workArea;
    private Long operatorCode;
    private MicroserviceOperatorDto operator;
    private Long managerCode;
    private MicroserviceManagerDto manager;
    private String observations;
    private MicroserviceMunicipalityDto municipality;

    public MicroserviceWorkspaceOperatorDto() {

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getNumberParcelsExpected() {
        return numberParcelsExpected;
    }

    public void setNumberParcelsExpected(Long numberParcelsExpected) {
        this.numberParcelsExpected = numberParcelsExpected;
    }

    public Double getWorkArea() {
        return workArea;
    }

    public void setWorkArea(Double workArea) {
        this.workArea = workArea;
    }

    public Long getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(Long operatorCode) {
        this.operatorCode = operatorCode;
    }

    public MicroserviceOperatorDto getOperator() {
        return operator;
    }

    public void setOperator(MicroserviceOperatorDto operator) {
        this.operator = operator;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Long getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(Long managerCode) {
        this.managerCode = managerCode;
    }

    public MicroserviceManagerDto getManager() {
        return manager;
    }

    public void setManager(MicroserviceManagerDto manager) {
        this.manager = manager;
    }

    public MicroserviceMunicipalityDto getMunicipality() {
        return municipality;
    }

    public void setMunicipality(MicroserviceMunicipalityDto municipality) {
        this.municipality = municipality;
    }
}
