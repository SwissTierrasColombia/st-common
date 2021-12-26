package com.ai.st.microservice.common.dto.ili;

import java.io.Serializable;
import java.util.List;

public class MicroserviceIliExportResultDto implements Serializable {

    private static final long serialVersionUID = 3333909202329876777L;

    private boolean status;
    private Long integrationId;
    private String pathFile;
    private MicroserviceIntegrationStatDto stats;
    private String modelVersion;
    private List<String> errors;

    public MicroserviceIliExportResultDto() {

    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getIntegrationId() {
        return integrationId;
    }

    public void setIntegrationId(Long integrationId) {
        this.integrationId = integrationId;
    }

    public String getPathFile() {
        return pathFile;
    }

    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
    }

    public MicroserviceIntegrationStatDto getStats() {
        return stats;
    }

    public void setStats(MicroserviceIntegrationStatDto stats) {
        this.stats = stats;
    }

    public String getModelVersion() {
        return modelVersion;
    }

    public void setModelVersion(String modelVersion) {
        this.modelVersion = modelVersion;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

}
