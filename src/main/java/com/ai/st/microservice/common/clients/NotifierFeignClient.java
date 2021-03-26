package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.notifier.MicroserviceNotificationRecoverAccountDto;
import feign.Feign;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "st-microservice-notifier", configuration = NotifierFeignClient.Configuration.class)
public interface NotifierFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/notifier/v1/notify/recover-account", consumes = APPLICATION_JSON_VALUE)
    void recoverAccount(@RequestBody MicroserviceNotificationRecoverAccountDto data);

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
