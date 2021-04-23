package com.example.pinpointpersonalplates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Starts the Service
@EnableSwagger2
@Import(SpringDataRestConfiguration.class)
@SpringBootApplication
@EnableCaching
public class PinpointpersonalplatesApplication {

    public static void main(String[] args) {
        SpringApplication.run(PinpointpersonalplatesApplication.class, args);
    }

}
