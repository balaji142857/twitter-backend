package com.kb.twitter.dispatcher;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RequestDispatchServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequestDispatchServiceApplication.class, args);
	}

	@Value("${queues.tweet.creation}")
	private String creationQueueName;

	@Value("${exchanges.twitter}")
	private String exchangeName;

	@Bean
	Queue queue() {
		return new Queue(creationQueueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(exchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("create.tweets");
	}

}
