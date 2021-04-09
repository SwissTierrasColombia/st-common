package com.ai.st.microservice.common.dto.notifier;

import java.io.Serializable;

public class MicroserviceNotificationRecoverAccountDto implements Serializable {

    private static final long serialVersionUID = -3073283184260792970L;

    private Long userCode;
    private String email;
    private String type;
    private int status;

    private String code;
    private String expirationDate;
    private String username;

    private String siteURL;
    private String siteEmail;

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

    public String getSiteURL() {
        return siteURL;
    }

    public void setSiteURL(String siteURL) {
        this.siteURL = siteURL;
    }

    public String getSiteEmail() {
        return siteEmail;
    }

    public void setSiteEmail(String siteEmail) {
        this.siteEmail = siteEmail;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSubject() {
        return "Notificación Sistema de Transición Barrido Predial – Recuperar Cuenta";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
