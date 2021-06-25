package com.ai.st.microservice.common.dto.administration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MicroserviceCreateUserDto implements Serializable {

    private static final long serialVersionUID = -2041172889834251468L;

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String password;
    private List<Long> roles;

    public MicroserviceCreateUserDto() {
        this.roles = new ArrayList<Long>();
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Long> getRoles() {
        return roles;
    }

    public void setRoles(List<Long> roles) {
        this.roles = roles;
    }

}
