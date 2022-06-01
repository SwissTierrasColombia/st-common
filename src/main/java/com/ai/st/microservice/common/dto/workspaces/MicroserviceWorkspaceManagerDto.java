package com.ai.st.microservice.common.dto.workspaces;

import com.ai.st.microservice.common.dto.managers.MicroserviceManagerDto;

import java.io.Serializable;
import java.util.Date;

public class MicroserviceWorkspaceManagerDto implements Serializable {

    private static final long serialVersionUID = -3496423811777143612L;

    private Long managerCode;
    private MicroserviceManagerDto manager;
    private String observations;
    private Date startDate;

    public MicroserviceWorkspaceManagerDto() {

    }

    public Long getManagerCode() {
        return managerCode;
    }

    public void setManagerCode(Long managerCode) {
        this.managerCode = managerCode;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public MicroserviceManagerDto getManager() {
        return manager;
    }

    public void setManager(MicroserviceManagerDto manager) {
        this.manager = manager;
    }

}
