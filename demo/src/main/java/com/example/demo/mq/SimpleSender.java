/*
package com.example.demo.mq;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

*/
/**
 * 生产者
 *//*

public class SimpleSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleSender.class);

    @Resource
    private RabbitTemplate template;

    private static final String queueName="simple.hello";

    public void send() {
        String message = "Hello World!";
        //真正开始发送消息
        this.template.convertAndSend(queueName, message);
        LOGGER.info(" [x] Sent '{}'", message);
    }

}*/
