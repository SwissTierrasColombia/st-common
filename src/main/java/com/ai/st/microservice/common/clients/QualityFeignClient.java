package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.quality.MicroserviceXTFAttachmentDto;
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

@FeignClient(name = "st-microservice-quality", configuration = QualityFeignClient.Configuration.class)
public interface QualityFeignClient {

    @GetMapping("/api/quality/v1/deliveries/{deliveryId}/products/{deliveryProductId}/xtf-attachments/{attachmentId}")
    MicroserviceXTFAttachmentDto findAttachmentById(
            @PathVariable("deliveryId") Long deliveryId,
            @PathVariable("deliveryProductId") Long deliveryProductId,
            @PathVariable("attachmentId") Long attachmentId);

    @PatchMapping("/api/quality/v1/deliveries/{deliveryId}/products/{deliveryProductId}/attachments/{attachmentId}/status/quality-process-finished")
    void udpdateXTFStatusToQualityProcessFinished(
            @PathVariable("deliveryId") Long deliveryId,
            @PathVariable("deliveryProductId") Long deliveryProductId,
            @PathVariable("attachmentId") Long attachmentId);

    @PatchMapping("/api/quality/v1/deliveries/{deliveryId}/products/{deliveryProductId}/attachments/{attachmentId}/status/accepted")
    void updateXTFStatusToAccepted(
            @PathVariable("deliveryId") Long deliveryId,
            @PathVariable("deliveryProductId") Long deliveryProductId,
            @PathVariable("attachmentId") Long attachmentId);

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
