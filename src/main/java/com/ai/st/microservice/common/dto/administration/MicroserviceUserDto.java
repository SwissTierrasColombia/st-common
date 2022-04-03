package com.ai.st.microservice.common.dto.administration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MicroserviceUserDto implements Serializable {

    private static final long serialVersionUID = -5121529899322990688L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Boolean enabled;
    private Date createdAt;
    private Date updatedAt;
    private List<MicroserviceRoleDto> roles;
    private Integer amountSuccessfulLogins;
    private Date lastLogin;

    public MicroserviceUserDto() {
        this.roles = new ArrayList<>();
    }

    public MicroserviceUserDto(Long id, String firstName, String lastName, String email, String username) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.roles = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<MicroserviceRoleDto> getRoles() {
        return roles;
    }

    public void setRoles(List<MicroserviceRoleDto> roles) {
        this.roles = roles;
    }

    public Integer getAmountSuccessfulLogins() {
        return amountSuccessfulLogins;
    }

    public void setAmountSuccessfulLogins(Integer amountSuccessfulLogins) {
        this.amountSuccessfulLogins = amountSuccessfulLogins;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }
}
