package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.reports.*;

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

@FeignClient(name = "st-microservice-reports", configuration = ReportFeignClient.Configuration.class)
public interface ReportFeignClient {

    @PostMapping(value = "/api/reports/v1/reports/download-supplies", consumes = APPLICATION_JSON_VALUE)
    MicroserviceReportInformationDto createReportDownloadSuppliesTotal(
            @RequestBody MicroserviceRequestReportDownloadSupplyDto data);

    @PostMapping(value = "/api/reports/v1/reports/delivery-au", consumes = APPLICATION_JSON_VALUE)
    MicroserviceReportInformationDto createReportDeliverySuppliesAC(
            @RequestBody MicroserviceRequestReportDeliveryACDto data);

    @PostMapping(value = "/api/reports/v1/reports/delivery-manager", consumes = APPLICATION_JSON_VALUE)
    MicroserviceReportInformationDto createReportDeliveryManager(
            @RequestBody MicroserviceRequestReportDeliveryManagerDto data);

    @PostMapping(value = "/api/reports/v1/reports/supplies-snr", consumes = APPLICATION_JSON_VALUE)
    MicroserviceReportInformationDto createReportSuppliesSNR(@RequestBody MicroserviceRequestReportSNRSuppliesDto data);

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
