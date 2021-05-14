package com.ai.st.microservice.common.dto.general;

import java.io.Serializable;

public class BasicResponseDto implements Serializable {

    private String message;
    private Integer code;

    public BasicResponseDto(String message, Integer code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
