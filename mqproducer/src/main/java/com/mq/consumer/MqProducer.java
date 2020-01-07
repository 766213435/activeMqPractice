package com.mq.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MqProducer {

    public static void main(String[] args) {
        SpringApplication.run(MqProducer.class, args);
    }

}
