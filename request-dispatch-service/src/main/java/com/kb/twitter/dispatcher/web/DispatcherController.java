package com.kb.twitter.dispatcher.web;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.twitter.web.model.TweetModel;

@RestController
public class DispatcherController {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${exchanges.twitter}")
	private String exchangeName;

	@PostMapping("tweet")
	public void postTweet(@RequestBody TweetModel tweet) {
		rabbitTemplate.convertAndSend(exchangeName, "create.tweets", tweet);
	}

}
