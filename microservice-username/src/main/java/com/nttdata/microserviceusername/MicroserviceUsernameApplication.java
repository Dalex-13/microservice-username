package com.nttdata.microserviceusername;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MicroserviceUsernameApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceUsernameApplication.class, args);
    }

}
