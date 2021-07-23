
package com.kb.twitter.web;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.twitter.entity.Tweet;
import com.kb.twitter.entity.User;
import com.kb.twitter.service.TweetService;
import com.kb.twitter.web.model.TweetModel;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RefreshScope
@RequestMapping("tweets")
public class TweetController {
	
	@Value("${max.tweets}")
	private Long maxTweets;
	
//	@Autowired
//	private Producer producer;
	
	@Autowired
	private TweetService service;

//	@Autowired
//	private ModelMapper mapper;
//	
//	@Autowired
//	private CommentClient commentService;
//	
//	@GetMapping
//	public String test() {
//		return "hello from tweet-service";
//	}
//	
//	@GetMapping("/test")
//	public Long testValue() {
//		return maxTweets;
//	}
//	
//	@GetMapping("/test-flow")
//	public Long getMaxComments() {
//		return commentService.getComments();
//	}
//	
//	@PostMapping("/msg")
//	public String sendMessagge(@RequestBody String message) {
//		log.info("received request to send message {}", message);
//		return "success";
//	}
	
	@PostMapping
	public void tweet(@RequestBody TweetModel tweet) {
		try {
			service.create(tweet);
		} catch(Exception e) {
			log.error("Error occured while posting tweet",e);
		}
		
	}
	
	@GetMapping
	public List<TweetModel> list() {
		log.info("request to list the tweets received at {}", Instant.now());
		return service.list();
	}
	
	@GetMapping("users")
	public List<User> users() {
		return service.getUsers();
	}

//	@GetMapping
//	public List<TweetModel> get() {
//		return service.list()
//				.stream()
//				.map(entity -> mapper.map(entity, TweetModel.class))
//				.collect(Collectors.toList());
//	}
//	
//	@GetMapping("{id}")
//	public TweetModel getTweet(@PathVariable Long id) {
//		Optional<Tweet> optional = service.get(id);
//		if(optional.isPresent()) {
//			return mapper.map(optional.get(), TweetModel.class);
//		}
//		//TODO app specific exception
//		else {
//			throw new RuntimeException("tweet with given id: "+id+" not found.");
//		}
//	}
//
//	@PostMapping
//	public Tweet tweet(@RequestBody TweetModel model) {
//		Tweet tweet = mapper.map(model, Tweet.class);
//		return service.create(tweet);
//	}
//
//	@DeleteMapping("{id}")
//	public void delete(@PathVariable Long id) {
//		service.delete(id);
//	}
//	
//	@GetMapping("{id}/comments")
//	public List<CommentModel> getComments(@PathVariable Long id) {
//		return commentService.getComments(id);
//	}

}
