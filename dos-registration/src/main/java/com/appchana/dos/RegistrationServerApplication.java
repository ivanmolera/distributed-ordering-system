package com.appchana.dos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@EnableEurekaServer
@SpringBootApplication
public class RegistrationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServerApplication.class, args);
    }
}
