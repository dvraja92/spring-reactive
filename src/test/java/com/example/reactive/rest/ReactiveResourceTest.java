package com.example.reactive.rest;

import com.example.reactive.model.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReactiveResourceTest {

    @Autowired
    private WebTestClient webTestClient;


    @Test
    public void whenValidId_thenGetByIdIs200() {

        webTestClient.get()
                .uri("/api/{id}", "One")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(User.class).value(user -> {
                    assertThat(user.getId()).isEqualTo("One");
                    assertThat(user.getName()).isNotBlank();
                    assertThat(user.getCity()).isNotBlank();
                    assertThat(user.getCountry()).isNotBlank();
                });
    }

    @Test
    public void whenInvalidId_thenGetByIdIs400() {

        webTestClient.get()
                .uri("/api/")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().is4xxClientError();
    }

}
