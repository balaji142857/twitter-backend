package com.kb.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.twitter.web.client.CommentClient;

import lombok.AllArgsConstructor;

@RestController
//@AllArgsConstructor
@RequestMapping("tweets")
public class TweetController {
	
	@Value("${max.tweets:9999}")
	private Long maxTweets;
	

//	private TweetService service;
//	private ModelMapper mapper;
	@Autowired
	private CommentClient commentService;
	
	@GetMapping
	public String test() {
		return "hello from tweet-service";
	}
	
	@GetMapping("/test")
	public Long testValue() {
		return maxTweets;
	}
	
	@GetMapping("/test-flow")
	public Long getMaxComments() {
		return commentService.getComments();
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
