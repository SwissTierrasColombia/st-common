package com.ai.st.microservice.common.exceptions;

public class BusinessException extends Exception {

    private static final long serialVersionUID = -6306603143465394875L;

    private final String messageError;

    public BusinessException(String message) {
        super();
        this.messageError = message;
    }

    public String getMessageError() {
        return messageError;
    }

    @Override
    public String getMessage() {
        return this.getMessageError();
    }

}
