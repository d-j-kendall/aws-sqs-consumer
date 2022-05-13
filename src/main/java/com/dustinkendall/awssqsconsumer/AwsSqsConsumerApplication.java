package com.dustinkendall.awssqsconsumer;

import io.awspring.cloud.messaging.config.annotation.EnableSqs;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSqsConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsConsumerApplication.class, args);
    }

}
