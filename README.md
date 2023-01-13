# Spring 5 (Boot 2.7) Reactive Example

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