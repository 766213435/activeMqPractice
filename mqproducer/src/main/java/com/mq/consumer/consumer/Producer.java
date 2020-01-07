package com.mq.consumer.consumer;

import com.alibaba.fastjson.JSON;
import com.mq.consumer.entity.EmailEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 10000)
    public void send() {
        EmailEntity msg = EmailEntity.builder().from("766213435@qq.com")
                .to("792487575@qq.com").subject("hello world")
                .content("hello world,hello china").build();

        jmsMessagingTemplate.convertAndSend(queue, JSON.toJSONString(msg));

    }
}
