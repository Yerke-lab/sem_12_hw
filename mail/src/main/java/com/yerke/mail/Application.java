package com.yerke.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import java.util.Scanner;

@SpringBootApplication
@ComponentScan(basePackages = {"com.yerke.mail"}) // Указываем пакет для сканирования
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		// Получаем канал для отправки сообщений
		MessageChannel inputChannel = context.getBean("inputChannel", MessageChannel.class);

		// Отправляем сообщение в канал
		inputChannel.send(MessageBuilder.withPayload("Тест spring Integration").build());

		// Ожидание ввода с консоли, чтобы приложение не завершалось
		System.out.println("Press Enter to exit...");
		new Scanner(System.in).nextLine();
	}
}
