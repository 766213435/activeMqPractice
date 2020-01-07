package com.mq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MqConsumer {

    public static void main(String[] args) {
        SpringApplication.run(MqConsumer.class, args);
    }

}
