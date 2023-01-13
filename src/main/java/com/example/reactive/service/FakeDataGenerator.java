package com.example.reactive.service;

import com.example.reactive.model.User;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakeDataGenerator {

    public User randomUser(String id) {
        Faker faker = new Faker();

        return User.builder()
                .country(faker.address().country())
                .name(faker.name().fullName())
                .city(faker.address().city())
                .id(id)
                .build();
    }

}
