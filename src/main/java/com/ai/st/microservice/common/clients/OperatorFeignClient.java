package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.operators.*;
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

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "st-microservice-operators", configuration = OperatorFeignClient.Configuration.class)
public interface OperatorFeignClient {

    @GetMapping("/api/operators/v1/operators/{operatorId}")
    MicroserviceOperatorDto findById(@PathVariable("operatorId") Long operatorId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/operators/v1/operators/{operatorId}/deliveries", consumes = APPLICATION_JSON_VALUE)
    MicroserviceDeliveryDto createDelivery(@PathVariable("operatorId") Long operatorId,
                                           @RequestBody MicroserviceCreateDeliveryDto data);

    @GetMapping("/api/operators/v1/operators/{operatorId}/deliveries")
    List<MicroserviceDeliveryDto> findDeliveriesByOperator(@PathVariable("operatorId") Long operatorId,
                                                           @RequestParam(name = "municipality", required = false) String municipalityCode);

    @GetMapping("api/operators/v1/users/{userCode}/operators")
    MicroserviceOperatorDto findByUserCode(@PathVariable("userCode") Long userCode);

    @GetMapping("/api/operators/v1/operators/{operatorId}/deliveries")
    List<MicroserviceDeliveryDto> findDeliveriesActivesByOperator(@PathVariable("operatorId") Long operatorId,
                                                                  @RequestParam(name = "active", required = false) Boolean isActive);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/operators/v1/deliveries/{deliveryId}/supplies/{supplyId}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceDeliveryDto updateSupplyDelivered(@PathVariable("deliveryId") Long deliveryId,
                                                  @PathVariable("supplyId") Long supplyId,
                                                  @RequestBody MicroserviceUpdateDeliveredSupplyDto updateSupply);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/operators/v1/deliveries/{deliveryId}/disable", consumes = APPLICATION_JSON_VALUE)
    MicroserviceDeliveryDto disableDelivery(@PathVariable("deliveryId") Long deliveryId);

    @GetMapping("/api/operators/v1/deliveries/{deliveryId}")
    MicroserviceDeliveryDto findDeliveryById(@PathVariable("deliveryId") Long deliveryId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/operators/v1/users", consumes = APPLICATION_JSON_VALUE)
    MicroserviceOperatorDto addUserToOperator(@RequestBody MicroserviceAddUserToOperatorDto requestAddUser);

    @GetMapping("/api/operators/v1/operators/{operatorId}/users")
    List<MicroserviceOperatorUserDto> getUsersByOperator(@PathVariable("operatorId") Long operatorId);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/operators/v1/deliveries/{deliveryId}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceDeliveryDto updateDelivery(@PathVariable("deliveryId") Long deliveryId,
                                           @RequestBody MicroserviceUpdateDeliveryDto data);

    @GetMapping("/api/operators/v1/operators/{operatorId}/deliveries")
    List<MicroserviceDeliveryDto> findDeliveriesByOperator(@PathVariable("operatorId") Long operatorId,
                                                           @RequestParam(name = "municipality", required = false) String municipalityCode,
                                                           @RequestParam(name = "active", required = false) Boolean active);

    @GetMapping("/api/operators/v1/deliveries/managers/{managerId}")
    List<MicroserviceDeliveryDto> findDeliveriesByManager(@PathVariable("managerId") Long managerId);

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
