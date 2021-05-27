package com.ai.st.microservice.common.clients;

import com.ai.st.microservice.common.dto.tasks.MicroserviceCancelTaskDto;
import com.ai.st.microservice.common.dto.tasks.MicroserviceCreateTaskDto;
import com.ai.st.microservice.common.dto.tasks.MicroserviceTaskDto;

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


@FeignClient(name = "st-microservice-tasks", configuration = TaskFeignClient.Configuration.class)
public interface TaskFeignClient {

    @GetMapping("/api/tasks/v1/tasks")
    List<MicroserviceTaskDto> findByUserAndState(
            @RequestParam(required = false, name = "member") Long memberCode,
            @RequestParam(required = false, name = "states") List<Long> taskStates);

    @GetMapping("/api/tasks/v1/tasks")
    List<MicroserviceTaskDto> findByStateAndCategory(
            @RequestParam(required = false, name = "states") List<Long> taskStates,
            @RequestParam(required = false, name = "categories") List<Long> categories);

    @PostMapping(value = "/api/tasks/v1/tasks", consumes = APPLICATION_JSON_VALUE)
    MicroserviceTaskDto createTask(
            @RequestBody MicroserviceCreateTaskDto createTaskDto);

    @DeleteMapping("/api/tasks/v1/tasks/{taskId}/members/{memberId}/")
    void removeMemberFromTask(
            @PathVariable(name = "taskId") Long taskId,
            @PathVariable(name = "memberId") Long memberId);

    @GetMapping("/api/tasks/v1/tasks/{id}")
    MicroserviceTaskDto findTaskById(
            @PathVariable(name = "id") Long id);

    @PutMapping("/api/tasks/v1/tasks/{id}/start")
    MicroserviceTaskDto startTask(
            @PathVariable(name = "id") Long id);

    @PutMapping("/api/tasks/v1/tasks/{id}/close")
    MicroserviceTaskDto closeTask(
            @PathVariable(name = "id") Long id);

    @PutMapping("/api/tasks/v1/tasks/{id}/cancel")
    MicroserviceTaskDto cancelTask(
            @PathVariable(name = "id") Long id,
            @RequestBody() MicroserviceCancelTaskDto cancelTaskRequest);

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
