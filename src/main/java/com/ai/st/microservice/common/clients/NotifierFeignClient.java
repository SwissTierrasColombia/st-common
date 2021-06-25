package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.notifier.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import feign.Feign;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@FeignClient(name = "st-microservice-notifier", configuration = NotifierFeignClient.Configuration.class)
public interface NotifierFeignClient {

    @PostMapping(value = "/api/notifier/v1/notify/recover-account", consumes = APPLICATION_JSON_VALUE)
    void recoverAccount(
            @RequestBody MicroserviceNotificationRecoverAccountDto data);

    @PostMapping(value = "/api/notifier/v1/notify/new_user", consumes = APPLICATION_JSON_VALUE)
    void creationUser(
            @RequestBody MicroserviceNotificationNewUserDto data);

    @PostMapping(value = "/api/notifier/v1/notify/municipality_management_assignment", consumes = APPLICATION_JSON_VALUE)
    void municipalityManagement(
            @RequestBody MicroserviceNotificationMunicipalityManagementDto data);

    @PostMapping(value = "/api/notifier/v1/notify/assignment_operation_municipality", consumes = APPLICATION_JSON_VALUE)
    void assignmentOperation(
            @RequestBody MicroserviceNotificationAssignmentOperationMunicipalityDto data);

    @PostMapping(value = "/api/notifier/v1/notify/input_request", consumes = APPLICATION_JSON_VALUE)
    void inputRequest(
            @RequestBody MicroserviceNotificationInputRequestDto data);

    @PostMapping(value = "/api/notifier/v1/notify/load_of_inputs", consumes = APPLICATION_JSON_VALUE)
    void loadOfInputs(
            @RequestBody MicroserviceNotificationLoadOfInputsDto data);

    @PostMapping(value = "/api/notifier/v1/notify/input_integrations", consumes = APPLICATION_JSON_VALUE)
    void inputIntegration(
            @RequestBody MicroserviceNotificationInputIntegrationsDto data);

    @PostMapping(value = "/api/notifier/v1/notify/task_assignment", consumes = APPLICATION_JSON_VALUE)
    void taskAssignment(
            @RequestBody MicroserviceNotificationTaskAssignmentDto data);

    @PostMapping(value = "/api/notifier/v1/notify/integration_file_generation", consumes = APPLICATION_JSON_VALUE)
    void productGenerated(
            @RequestBody MicroserviceNotificationIntegrationFileGenerationDto data);

    @PostMapping(value = "/api/notifier/v1/notify/delivery_of_inputs", consumes = APPLICATION_JSON_VALUE)
    void deliverySupplies(
            @RequestBody MicroserviceNotificationDeliveryOfInputsDto data);

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
