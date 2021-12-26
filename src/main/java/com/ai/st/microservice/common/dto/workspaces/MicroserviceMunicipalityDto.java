package com.ai.st.microservice.common.dto.workspaces;

import java.io.Serializable;

public class MicroserviceMunicipalityDto implements Serializable {

    private static final long serialVersionUID = 5342779101170022387L;

    private Long id;
    private String name;
    private String code;
    private MicroserviceDepartmentDto department;

    public MicroserviceMunicipalityDto() {

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MicroserviceDepartmentDto getDepartment() {
        return department;
    }

    public void setDepartment(MicroserviceDepartmentDto department) {
        this.department = department;
    }

}
