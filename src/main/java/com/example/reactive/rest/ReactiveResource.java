package com.example.reactive.rest;

import com.example.reactive.model.User;
import com.example.reactive.service.FakeDataGenerator;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReactiveResource {

    private final FakeDataGenerator fakeDataGenerator;

    @GetMapping("/{id}")
    public Mono<User> getById(@NotBlank @PathVariable String id) {
        return Mono.just(fakeDataGenerator.randomUser(id));
    }


}
