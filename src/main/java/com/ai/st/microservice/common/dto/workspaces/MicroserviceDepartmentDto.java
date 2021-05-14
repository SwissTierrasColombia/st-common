package com.ai.st.microservice.common.dto.workspaces;

import java.io.Serializable;

public class MicroserviceDepartmentDto implements Serializable {

    private static final long serialVersionUID = -4872570330522596800L;
    private Long id;
    private String name;
    private String code;

    public MicroserviceDepartmentDto() {

    }

    public MicroserviceDepartmentDto(Long id, String name, String code) {
        super();
        this.id = id;
        this.name = name;
        this.code = code;
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

}
