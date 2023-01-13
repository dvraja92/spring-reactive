# Spring 6 (Boot 3) Reactive Example

## PreRequisites

- Java 17
- Maven

## Overview

A simple spring webflux application with single resource/controller to return Random User (_using java-faker_) which contains : id, name, city, country


## Tests

Controller tests which will validate success & failure cases and evaluates the response accordingly.


## Run

`mvn spring-boot:run`

Run it on browser : http://localhost:8080/api/{id} -> where id can be any random string

Example: http://localhost:8080/api/hello

curl : `curl --location --request GET 'http://localhost:8080/api/hello'`

Example response 
```json
{
  "id": "hello",
  "name": "Cleve Spinka IV",
  "city": "West Moises",
  "country": "Samoa"
}
```


## Code Walkthrough

- _com.example.reactive.service.FakeDataGenerator_

    Spring bean (Service) which is responsible to provide user information. As of now using _java-faker_ library.


- _com.example.reactive.model.User_

    User pojo to hold the user basic information : id, name, city, country. Making use of _lombok_


- _com.example.reactive.rest.ReactiveResource _

    Spring rest-controller which defines the API using web annotations but operates in reactive way.


- (test)_com.example.reactive.rest.ReactiveResourceTest_

    Spring rest-controller test making use of spring-test environment to test and perform checks on response & http status. Covers both success & failure scenarios.

