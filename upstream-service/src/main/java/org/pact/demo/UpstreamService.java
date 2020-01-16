package org.pact.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class UpstreamService {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(UpstreamService.class);
        app.setDefaultProperties(Collections
          .singletonMap("server.port", "9090"));
        app.run(args);
    }

}
