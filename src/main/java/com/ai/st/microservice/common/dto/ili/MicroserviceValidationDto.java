package com.ai.st.microservice.common.dto.ili;

import java.io.Serializable;
import java.util.List;

public class MicroserviceValidationDto implements Serializable {

    private static final long serialVersionUID = 1185381344046839161L;

    private Boolean isValid;
    private Long requestId;
    private Long supplyRequestedId;
    private String filenameTemporal;
    private Long userCode;
    private String observations;
    private List<String> errors;
    private String referenceId;

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Long getSupplyRequestedId() {
        return supplyRequestedId;
    }

    public void setSupplyRequestedId(Long supplyRequestedId) {
        this.supplyRequestedId = supplyRequestedId;
    }

    public String getFilenameTemporal() {
        return filenameTemporal;
    }

    public void setFilenameTemporal(String filenameTemporal) {
        this.filenameTemporal = filenameTemporal;
    }

    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }
}
