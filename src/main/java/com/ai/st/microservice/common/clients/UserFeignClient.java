package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.administration.MicroserviceChangePasswordDto;
import com.ai.st.microservice.common.dto.administration.MicroserviceCreateUserDto;
import com.ai.st.microservice.common.dto.administration.MicroserviceUpdateUserDto;
import com.ai.st.microservice.common.dto.administration.MicroserviceUserDto;
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

@FeignClient(name = "st-microservice-administration", configuration = UserFeignClient.Configuration.class)
public interface UserFeignClient {

    @GetMapping("/api/administration/v1/users/{id}")
    MicroserviceUserDto findById(@PathVariable("id") Long id);

    @GetMapping("/api/administration/v1/users/token")
    MicroserviceUserDto findByToken(@RequestParam(name = "token") String token);

    @PostMapping(value = "/api/administration/v1/users", consumes = APPLICATION_JSON_VALUE)
    MicroserviceUserDto createUser(@RequestBody MicroserviceCreateUserDto user) throws BusinessException;

    @PostMapping(value = "/api/administration/v1/users/{id}/reset-password", consumes = APPLICATION_JSON_VALUE)
    MicroserviceUserDto changeUserPassword(@PathVariable(name = "id") Long userId,
            @RequestBody MicroserviceChangePasswordDto requestChangePassword) throws BusinessException;

    @PutMapping(value = "/api/administration/v1/users/{id}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceUserDto updateUser(@PathVariable(name = "id") Long id,
            @RequestBody MicroserviceUpdateUserDto updateUser) throws BusinessException;

    @PutMapping(value = "/api/administration/v1/users/{userId}/disable", consumes = APPLICATION_JSON_VALUE)
    MicroserviceUserDto disableUser(@PathVariable(name = "userId") Long userId) throws BusinessException;

    @PutMapping(value = "/api/administration/v1/users/{userId}/enable", consumes = APPLICATION_JSON_VALUE)
    MicroserviceUserDto enableUser(@PathVariable(name = "userId") Long userId) throws BusinessException;

    @GetMapping("/api/administration/v1/users")
    List<MicroserviceUserDto> findUsersByRoles(@RequestParam(name = "roles", required = false) List<Long> roles);

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
