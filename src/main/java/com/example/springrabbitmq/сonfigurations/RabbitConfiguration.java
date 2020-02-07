package com.example.springrabbitmq.сonfigurations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.MessageListenerContainer;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${spring.rabbitmq.template.default-receive-queue}")
    private String queueName;

    @Value("${spring.rabbitmq.template.exchange}")
    private String exchangeName;


    @Bean
    public MessageListenerContainer messageListenerContainer(ConnectionFactory connectionFactory) {
        return new SimpleMessageListenerContainer(connectionFactory);
    }

    @Bean
    public Queue myQueue2() {
        return new Queue(queueName, true);
    }

    @Bean
    public DirectExchange directExchange2() {
        return new DirectExchange(exchangeName);
    }

    @Bean
    public Binding infoBinding2() {
        return BindingBuilder.bind(myQueue2()).to(directExchange2()).with("info");
    }

}