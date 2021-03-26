package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.providers.*;
import com.ai.st.microservice.common.exceptions.BusinessException;
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

@FeignClient(name = "st-microservice-providers", configuration = ProviderFeignClient.Configuration.class)
public interface ProviderFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/api/providers-supplies/v1/requests", consumes = APPLICATION_JSON_VALUE)
    MicroserviceRequestDto createRequest(@RequestBody MicroserviceCreateRequestDto request)
            throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/users/{userCode}/providers")
    MicroserviceProviderDto findByUserCode(@PathVariable("userCode") Long userCode);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}")
    MicroserviceProviderDto findById(@PathVariable(name = "providerId", required = true) Long providerId);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/requests")
    List<MicroserviceRequestDto> getRequestsByProvider(@PathVariable("providerId") Long providerId,
                                                       @RequestParam(required = false, name = "state") Long requestStateId);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/requests/closed")
    List<MicroserviceRequestDto> getRequestsByProviderClosed(@PathVariable("providerId") Long providerId,
                                                             @RequestParam(required = false, name = "user") Long userCode);

    @GetMapping("/api/providers-supplies/v1/requests/{requestId}")
    MicroserviceRequestDto findRequestById(@PathVariable("requestId") Long requestId);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/users")
    List<MicroserviceProviderUserDto> findUsersByProviderId(@PathVariable("providerId") Long providerId)
            throws BusinessException;

    @RequestMapping(method = RequestMethod.PUT, value = "/api/providers-supplies/v1/requests/{requestId}/supplies/{supplyRequestedId}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceRequestDto updateSupplyRequested(@PathVariable("requestId") Long requestId,
                                                 @PathVariable("supplyRequestedId") Long supplyRequestedId,
                                                 @RequestBody MicroserviceUpdateSupplyRequestedDto updateSupply);

    @PutMapping("/api/providers-supplies/v1/requests/{requestId}/delivered")
    MicroserviceRequestDto closeRequest(@PathVariable("requestId") Long requestId,
                                        @RequestParam(name = "closed_by") Long userCode);

    @RequestMapping(method = RequestMethod.POST, value = "/api/providers-supplies/v1/users", consumes = APPLICATION_JSON_VALUE)
    List<MicroserviceProviderUserDto> addUserToProvide(@RequestBody MicroserviceAddUserToProviderDto data);

    @GetMapping("/api/providers-supplies/v1/types-supplies/{typeSupplyId}")
    MicroserviceTypeSupplyDto findTypeSuppleById(@PathVariable("typeSupplyId") Long typeSupplyId);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/users")
    List<MicroserviceProviderUserDto> findUsersByProviderIdAndProfiles(@PathVariable("providerId") Long providerId,
                                                                       @RequestParam(name = "profiles", required = false) List<Long> profiles) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/requests/emmiters")
    List<MicroserviceRequestDto> findRequestsByEmmiters(
            @RequestParam(name = "emmiter_code", required = true) Long emmiterCode,
            @RequestParam(name = "emmiter_type", required = true) String emmiterType);

    @RequestMapping(method = RequestMethod.POST, value = "/api/providers-supplies/v1/administrators", consumes = APPLICATION_JSON_VALUE)
    List<MicroserviceProviderAdministratorDto> addAdministratorToProvide(
            @RequestBody MicroserviceAddAdministratorToProviderDto data);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/administrators")
    List<MicroserviceProviderAdministratorDto> findAdministratorsByProviderId(@PathVariable("providerId") Long providerId)
            throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/administrators/{userCode}/roles")
    List<MicroserviceProviderRoleDto> findRolesByUser(@PathVariable("userCode") Long userCode);

    @GetMapping("/api/providers-supplies/v1/administrators/{userCode}/providers")
    MicroserviceProviderDto findProviderByAdministrator(@PathVariable("userCode") Long userCode);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/providers-supplies/v1/users", consumes = APPLICATION_JSON_VALUE)
    List<MicroserviceProviderUserDto> removeUserToProvider(@RequestBody MicroserviceAddUserToProviderDto data)
            throws BusinessException;

    @RequestMapping(method = RequestMethod.POST, value = "/api/providers-supplies/v1/providers/{providerId}/profiles", consumes = APPLICATION_JSON_VALUE)
    MicroserviceProviderProfileDto createProfile(@PathVariable("providerId") Long providerId,
                                                 @RequestBody MicroserviceCreateProviderProfileDto createProviderProfileDto) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/profiles")
    List<MicroserviceProviderProfileDto> getProfilesByProvider(@PathVariable("providerId") Long providerId)
            throws BusinessException;

    @RequestMapping(method = RequestMethod.PUT, value = "/api/providers-supplies/v1/providers/{providerId}/profiles/{profileId}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceProviderProfileDto updateProfile(@PathVariable("providerId") Long providerId,
                                                 @PathVariable("profileId") Long profileId,
                                                 @RequestBody MicroserviceCreateProviderProfileDto createProviderProfileDto) throws BusinessException;

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/providers-supplies/v1/providers/{providerId}/profiles/{profileId}", consumes = APPLICATION_JSON_VALUE)
    void deleteProfile(@PathVariable("providerId") Long providerId, @PathVariable("profileId") Long profileId) throws BusinessException;

    @RequestMapping(method = RequestMethod.POST, value = "/api/providers-supplies/v1/providers/{providerId}/type-supplies", consumes = APPLICATION_JSON_VALUE)
    MicroserviceTypeSupplyDto createTypeSupplies(@PathVariable("providerId") Long providerId,
                                                 @RequestBody MicroserviceCreateTypeSupplyDto createTypeSupplyDto) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/types-supplies")
    List<MicroserviceTypeSupplyDto> getTypesSuppliesByProvider(@PathVariable("providerId") Long providerId)
            throws BusinessException;

    @RequestMapping(method = RequestMethod.PUT, value = "/api/providers-supplies/v1/providers/{providerId}/type-supplies/{typeSupplyId}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceTypeSupplyDto updateTypeSupplies(@PathVariable("providerId") Long providerId,
                                                 @PathVariable("typeSupplyId") Long typeSupplyId,
                                                 @RequestBody MicroserviceCreateTypeSupplyDto data) throws BusinessException;

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/providers-supplies/v1/providers/{providerId}/type-supplies/{typeSupplyId}", consumes = APPLICATION_JSON_VALUE)
    void deleteTypeSupply(@PathVariable("providerId") Long providerId, @PathVariable("typeSupplyId") Long typeSupplyId)
            throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/users/{userCode}/profiles")
    List<MicroserviceProviderProfileDto> findProfilesByUser(@PathVariable("userCode") Long userCode);

    @GetMapping("/api/providers-supplies/v1/requests/search-manager-municipality")
    MicroserviceRequestPaginatedDto getRequestsByManagerAndMunicipality(
            @RequestParam(name = "manager", required = true) Long managerCode,
            @RequestParam(name = "municipality", required = true) String municipalityCode,
            @RequestParam(name = "page", required = true) Integer page) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/requests/search-manager-provider")
    MicroserviceRequestPaginatedDto getRequestsByManagerAndProvider(
            @RequestParam(name = "manager", required = true) Long managerCode,
            @RequestParam(name = "provider", required = true) Long providerId,
            @RequestParam(name = "page", required = true) Integer page) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/requests/search-manager-package")
    List<MicroserviceRequestDto> getRequestsByManagerAndPackage(
            @RequestParam(name = "manager", required = true) Long managerCode,
            @RequestParam(name = "package_label", required = true) String packageLabel) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/requests/search-package")
    List<MicroserviceRequestDto> getRequestsByPackage(
            @RequestParam(name = "package_label", required = true) String packageLabel) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/supplies-requested")
    List<MicroserviceSupplyRequestedDto> getSuppliesRequestedToReview(@PathVariable("providerId") Long providerId,
                                                                      @RequestParam(name = "states", required = true) List<Long> states) throws BusinessException;

    @GetMapping("/api/providers-supplies/v1/supplies-requested/{supplyRequestedId}")
    MicroserviceSupplyRequestedDto getSupplyRequested(@PathVariable("supplyRequestedId") Long supplyRequestedId);

    @RequestMapping(method = RequestMethod.POST, value = "/api/providers-supplies/v1/supplies-requested/{supplyRequestedId}/revision", consumes = APPLICATION_JSON_VALUE)
    MicroserviceSupplyRevisionDto createSupplyRevision(@PathVariable("supplyRequestedId") Long supplyRequestedId,
                                                       @RequestBody MicroserviceCreateSupplyRevisionDto createRevisionDto);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/providers-supplies/v1/supplies-requested/{supplyRequestedId}/revision/{supplyRevisionId}", consumes = APPLICATION_JSON_VALUE)
    void deleteSupplyRevision(@PathVariable("supplyRequestedId") Long supplyRequestedId,
                              @PathVariable("supplyRevisionId") Long supplyRevisionId);

    @GetMapping("/api/providers-supplies/v1/supplies-requested/{supplyRequestedId}/revision")
    MicroserviceSupplyRevisionDto getSupplyRevisionFromSupplyRequested(@PathVariable("supplyRequestedId") Long supplyRequestedId);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/providers-supplies/v1/supplies-requested/{supplyRequestedId}/revision/{revisionId}", consumes = APPLICATION_JSON_VALUE)
    MicroserviceSupplyRevisionDto updateSupplyRevision(@PathVariable("supplyRequestedId") Long supplyRequestedId,
                                                       @PathVariable("revisionId") Long revisionId,
                                                       @RequestBody MicroserviceUpdateSupplyRevisionDto createRevisionDto);

    // Petitions Module
    @RequestMapping(method = RequestMethod.POST, value = "/api/providers-supplies/v1/providers/{providerId}/petitions", consumes = APPLICATION_JSON_VALUE)
    MicroservicePetitionDto createPetition(@PathVariable("providerId") Long providerId,
                                           @RequestBody MicroserviceCreatePetitionDto createPetitionDto);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/petitions-manager/{managerId}")
    List<MicroservicePetitionDto> getPetitionsForManager(@PathVariable("providerId") Long providerId,
                                                         @PathVariable("managerId") Long managerId);

    @GetMapping("/api/providers-supplies/v1/providers/petitions-manager/{managerId}")
    List<MicroservicePetitionDto> getPetitionsByManager(@PathVariable("managerId") Long managerId);

    @GetMapping("/api/providers-supplies/v1/providers/{providerId}/petitions")
    List<MicroservicePetitionDto> getPetitionsForProvider(@PathVariable("providerId") Long providerId,
                                                          @RequestParam(name = "states", required = true) List<Long> states);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/providers-supplies/v1/providers/{providerId}/petitions/{petitionId}", consumes = APPLICATION_JSON_VALUE)
    MicroservicePetitionDto updatePetition(@PathVariable("providerId") Long providerId,
                                           @PathVariable("petitionId") Long petitionId,
                                           @RequestBody MicroserviceUpdatePetitionDto updatePetitionDto) throws BusinessException;

    // Supplies Module

    @RequestMapping(method = RequestMethod.PUT, value = "/api/providers-supplies/v1/types-supplies/{typeSupplyId}/enable", consumes = APPLICATION_JSON_VALUE)
    MicroserviceTypeSupplyDto enableTypeSupply(@PathVariable("typeSupplyId") Long typeSupplyId) throws BusinessException;

    @RequestMapping(method = RequestMethod.PUT, value = "/api/providers-supplies/v1/types-supplies/{typeSupplyId}/disable", consumes = APPLICATION_JSON_VALUE)
    MicroserviceTypeSupplyDto disableTypeSupply(@PathVariable("typeSupplyId") Long typeSupplyId) throws BusinessException;

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
