package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.managers.MicroserviceAddUserToManagerDto;
import com.ai.st.microservice.common.dto.managers.MicroserviceManagerDto;
import com.ai.st.microservice.common.dto.managers.MicroserviceManagerProfileDto;
import com.ai.st.microservice.common.dto.managers.MicroserviceManagerUserDto;
import com.ai.st.microservice.common.exceptions.BusinessException;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.*;

import feign.Feign;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "st-microservice-managers", configuration = ManagerFeignClient.Configuration.class)
public interface ManagerFeignClient {

    @GetMapping("/api/managers/v1/managers/{managerId}")
    MicroserviceManagerDto findById(@PathVariable("managerId") Long managerId);

    @GetMapping("/api/managers/v1/users/{userCode}/managers")
    MicroserviceManagerDto findByUserCode(@PathVariable("userCode") Long userCode);

    @PostMapping(value = "/api/managers/v1/users", consumes = APPLICATION_JSON_VALUE)
    MicroserviceManagerUserDto addUserToManager(@RequestBody MicroserviceAddUserToManagerDto data);

    @GetMapping("/api/managers/v1/users/{userCode}/profiles")
    List<MicroserviceManagerProfileDto> findProfilesByUser(@PathVariable("userCode") Long userCode);

    @GetMapping("/api/managers/v1/managers/{managerId}/users")
    List<MicroserviceManagerUserDto> findUsersByManager(@PathVariable("managerId") Long managerId,
            @RequestParam(required = false, name = "profiles") List<Long> profiles);

    @DeleteMapping(value = "/api/managers/v1/users", consumes = APPLICATION_JSON_VALUE)
    MicroserviceManagerUserDto removeUserToManager(@RequestBody MicroserviceAddUserToManagerDto data)
            throws BusinessException;

    @GetMapping(value = "/api/managers/v1/profiles", consumes = APPLICATION_JSON_VALUE)
    List<MicroserviceManagerProfileDto> getManagerProfiles();

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
