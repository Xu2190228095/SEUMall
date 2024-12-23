/*
package com.example.demo.config;

import com.example.demo.mq.SimpleReceiver;
import com.example.demo.mq.SimpleSender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleRabbitConfig {

    @Bean
    public Queue hello() {
        return new Queue("simple.hello");
    } //队列

    @Bean
    public SimpleSender simpleSender(){
        return new SimpleSender();
    }//发送

    @Bean
    public SimpleReceiver simpleReceiver(){
        return new SimpleReceiver();
    }//接受消息

}*/
