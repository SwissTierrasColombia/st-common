package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.ili.*;

import feign.Feign;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "st-microservice-ili-old-versions", configuration = IliOldFeignClient.Configuration.class)
public interface IliOldFeignClient {

    @PostMapping(value = "/api/ili/ilivalidator/v1/validate/background", consumes = APPLICATION_JSON_VALUE)
    void startValidation(@RequestBody MicroserviceIlivalidatorBackgroundDto data);

    class Configuration {

        @Bean
        Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
            return new SpringFormEncoder(new SpringEncoder(converters));
        }

        @Bean
        @Scope("prototype")
        public Feign.Builder feignBuilder() {
            return Feign.builder();
        }

    }

}
