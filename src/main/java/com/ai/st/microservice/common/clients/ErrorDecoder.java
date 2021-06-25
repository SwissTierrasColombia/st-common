package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.general.BasicResponseDto;
import com.ai.st.microservice.common.exceptions.BusinessException;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;

import feign.Response;

import java.io.IOException;

public class ErrorDecoder implements feign.codec.ErrorDecoder {

    private final feign.codec.ErrorDecoder defaultErrorDecoder = new Default();
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {

        if (response.body() == null) {
            return defaultErrorDecoder.decode(methodKey, response);
        }

        BasicResponseDto error;
        try {
            error = mapper.readValue(response.body().asInputStream(), BasicResponseDto.class);
        } catch (IOException e) {
            return defaultErrorDecoder.decode(methodKey, response);
        }

        final HttpStatus status = HttpStatus.valueOf(response.status());

        if (status.is4xxClientError()) {
            return new BusinessException(error.getMessage());
        } else {
            return new BusinessException("Error");
        }

    }

}