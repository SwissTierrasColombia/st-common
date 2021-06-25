package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.ili.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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


@FeignClient(name = "st-microservice-ili", configuration = IliFeignClient.Configuration.class)
public interface IliFeignClient {

    @PostMapping(value = "/api/ili/ili2pg/v1/integration/cadastre-registration-reference", consumes = APPLICATION_JSON_VALUE)
    void startIntegrationCadastreRegistration(
            @RequestBody MicroserviceIntegrationCadastreRegistrationDto data);

    @PostMapping(value = "/api/ili/ili2pg/v1/export", consumes = APPLICATION_JSON_VALUE)
    void startExport(
            @RequestBody MicroserviceIli2pgExportDto data);

    @PostMapping(value = "/api/ili/ilivalidator/v1/validate/background", consumes = APPLICATION_JSON_VALUE)
    void startValidation(
            @RequestBody MicroserviceIlivalidatorBackgroundDto data);

    @PostMapping(value = "/api/ili/ili2pg/v1/import-reference", consumes = APPLICATION_JSON_VALUE)
    void startImport(
            @RequestBody MicroserviceIli2pgImportReferenceDto data);

    @GetMapping("/api/ili/query/v1/execute/registral-to-revision")
    MicroserviceQueryResultRegistralRevisionDto getRecordsFromQueryRegistralRevision(
            @RequestParam(name = "host") String host,
            @RequestParam(name = "database") String database,
            @RequestParam(name = "schema") String schema,
            @RequestParam(name = "port") String port,
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "modelVersion") String modelVersion,
            @RequestParam(name = "concept") Long conceptId,
            @RequestParam(name = "page") int page,
            @RequestParam(name = "limit") int limit);

    @PutMapping(value = "/api/ili/query/v1/execute/update-to-revision", consumes = APPLICATION_JSON_VALUE)
    void updateRecordFromRevision(
            @RequestBody MicroserviceExecuteQueryUpdateToRevisionDto data);

    @PostMapping(value = "/api/ili/ili2pg/v1/export-reference", consumes = APPLICATION_JSON_VALUE)
    void startExportReference(
            @RequestBody MicroserviceIli2pgExportReferenceDto data);

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
