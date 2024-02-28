package com.yerke.mail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;


@Configuration
public class IntegrationConfig {

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    @ServiceActivator(inputChannel = "inputChannel")
    public MessageHandler messageHandler() {
        return message -> {
            System.out.println("Received message: " + message.getPayload());
            // Здесь можно выполнить какую-то обработку сообщения
        };
    }
    @MessagingGateway(defaultRequestChannel = "inputChannel")
    public interface MessageGateway {
        void sendMessage(@Payload String message);
    }
}

