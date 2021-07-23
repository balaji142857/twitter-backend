package com.kb.twitter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kb.twitter.entity.Tweet;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Producer {

    private static final String TOPIC = "tweets";

    @Autowired
    private KafkaTemplate<String, Tweet> kafkaTemplate;

    public void sendTweet(Tweet tweet) {
    	log.info("recieved request for creating tweet {}", tweet);
    	kafkaTemplate.send(TOPIC, tweet);
    }
}