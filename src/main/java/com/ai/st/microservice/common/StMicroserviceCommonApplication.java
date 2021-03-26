package com.ai.st.microservice.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StMicroserviceCommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(StMicroserviceCommonApplication.class, args);
    }

}
