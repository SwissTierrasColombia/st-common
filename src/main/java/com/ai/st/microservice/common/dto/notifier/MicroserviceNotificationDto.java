package com.ai.st.microservice.common.dto.notifier;

import java.io.Serializable;

public class MicroserviceNotificationDto implements Serializable {

    private Long userCode;
    private String email;
    private String subject;
    private String message;
    private String type;
    private int status;

    public MicroserviceNotificationDto() {

    }

    public MicroserviceNotificationDto(Long userCode, String email, String subject, String message, String type) {
        this.userCode = userCode;
        this.email = email;
        this.message = message;
        this.type = type;
        this.subject = subject;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
