package com.appchana.dos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ivanmolera on 12/04/2018.
 */
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class UserAuthenticacionApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthenticacionApplication.class, args);
    }
}
