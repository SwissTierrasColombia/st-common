package com.ai.st.microservice.common.dto.reports;

import java.io.Serializable;
import java.util.List;

public final class MicroserviceRequestReportSNRSuppliesDto extends MicroserviceReportRequestDto
        implements Serializable {

    private List<MicroserviceRequestReportSNRDto> requests;
    private String createdAt;

    public MicroserviceRequestReportSNRSuppliesDto() {
    }

    public List<MicroserviceRequestReportSNRDto> getRequests() {
        return requests;
    }

    public void setRequests(List<MicroserviceRequestReportSNRDto> requests) {
        this.requests = requests;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

}
