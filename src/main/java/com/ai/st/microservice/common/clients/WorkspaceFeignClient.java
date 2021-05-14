package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.workspaces.MicroserviceWorkspaceDto;
import com.ai.st.microservice.common.dto.workspaces.MicroserviceWorkspaceOperatorDto;
import feign.Feign;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "st-microservice-workspaces", configuration = WorkspaceFeignClient.Configuration.class)
public interface WorkspaceFeignClient {

    @GetMapping("/api/workspaces/v1/workspaces/operators/{operatorCode}")
    List<MicroserviceWorkspaceOperatorDto> findWorkspacesByOperator(@PathVariable("operatorCode") Long operatorCode);

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
