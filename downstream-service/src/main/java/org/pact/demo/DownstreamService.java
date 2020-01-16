package org.pact.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class DownstreamService {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DownstreamService.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "8080"));
        app.run(args);
    }

}
