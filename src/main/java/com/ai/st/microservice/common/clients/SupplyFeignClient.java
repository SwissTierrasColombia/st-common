package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.supplies.MicroserviceCreateSupplyDto;
import com.ai.st.microservice.common.dto.supplies.MicroserviceDataPaginatedDto;
import com.ai.st.microservice.common.dto.supplies.MicroserviceSupplyDto;
import com.ai.st.microservice.common.dto.supplies.MicroserviceUpdateSupplyDto;
import com.ai.st.microservice.common.exceptions.BusinessException;

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

import java.util.List;

@FeignClient(name = "st-microservice-supplies", configuration = SupplyFeignClient.Configuration.class)
public interface SupplyFeignClient {

    @PostMapping(value = "/api/supplies/v1/supplies", consumes = APPLICATION_JSON_VALUE)
    MicroserviceSupplyDto createSupply(
            @RequestBody MicroserviceCreateSupplyDto createSupply);

    @GetMapping("/api/supplies/v1/supplies/municipality/{municipalityId}")
    List<MicroserviceSupplyDto> getSuppliesByMunicipalityCode(
            @PathVariable(name = "municipalityId") String municipalityId,
            @RequestParam(name = "states", required = false) List<Long> states);

    @GetMapping("/api/supplies/v1/supplies/municipality/{municipalityId}")
    MicroserviceDataPaginatedDto getSuppliesByMunicipalityCodeByFilters(
            @PathVariable(name = "municipalityId") String municipalityId,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "manager", required = false) Long managerCode,
            @RequestParam(name = "requests", required = false) List<Long> requests,
            @RequestParam(name = "states", required = false) List<Long> states);

    @GetMapping("/api/supplies/v1/supplies/{supplyId}")
    MicroserviceSupplyDto findSupplyById(
            @PathVariable(name = "supplyId") Long supplyId);

    @DeleteMapping("/api/supplies/v1/supplies/{supplyId}")
    void deleteSupplyById(
            @PathVariable(name = "supplyId") Long supplyId);

    @PutMapping(value = "/api/supplies/v1/supplies/{supplyId}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceSupplyDto updateSupply(
            @PathVariable(name = "supplyId") Long supplyId,
            @RequestBody MicroserviceUpdateSupplyDto updateSupply)
            throws BusinessException;

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
