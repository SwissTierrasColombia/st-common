package com.ai.st.microservice.common.dto.notifier;

import java.io.Serializable;
import java.util.Date;

public class MicroserviceNotificationIntegrationFileGenerationDto implements Serializable {

    private static final long serialVersionUID = 3050930525504636650L;

    private Long userCode;
    private String email;
    private String type;
    private int status;
    private String mpio;
    private String dpto;
    private Date requestDate;

    public MicroserviceNotificationIntegrationFileGenerationDto() {

    }

    public Long getUserCode() {
        return userCode;
    }

    public void setUserCode(Long userCode) {
        this.userCode = userCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMpio() {
        return mpio;
    }

    public void setMpio(String mpio) {
        this.mpio = mpio;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

}
