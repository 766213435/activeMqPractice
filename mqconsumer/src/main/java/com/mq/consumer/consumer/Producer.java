package com.mq.consumer.consumer;

import com.alibaba.fastjson.JSON;
import com.mq.consumer.entity.EmailEntity;
import com.mq.consumer.sendthread.SendThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadPoolExecutor;

@Component
@Slf4j
public class Producer {

    @Autowired
    private JavaMailSender javaMailSender;

    @JmsListener(destination = "${my_queue}")
    public void receive(String msg) {

        if (StringUtils.isEmpty(msg)) {
            return;
        }
        EmailEntity emailEntity = JSON.parseObject(msg, EmailEntity.class);
        ThreadPoolExecutor thread = SendThreadPool.getThread();
        thread.execute(new Runnable() {
            @Override
            public void run() {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom(emailEntity.getFrom());
                mailMessage.setTo(emailEntity.getTo());
                mailMessage.setSubject(emailEntity.getSubject());
                mailMessage.setText(emailEntity.getContent());
                javaMailSender.send(mailMessage);
                log.info("send success");
            }
        });

    }
}
