package com.kb.twitter.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kb.twitter.entity.Tweet;
import com.kb.twitter.service.TweetService;
import com.kb.twitter.web.client.CommentClient;
import com.kb.twitter.web.model.CommentModel;
import com.kb.twitter.web.model.TweetModel;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("tweets")
public class TweetController {

	private TweetService service;
	private ModelMapper mapper;
	private CommentClient commentService;

	@GetMapping
	public List<TweetModel> get() {
		return service.list()
				.stream()
				.map(entity -> mapper.map(entity, TweetModel.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("{id}")
	public TweetModel getTweet(@PathVariable Long id) {
		Optional<Tweet> optional = service.get(id);
		if(optional.isPresent()) {
			return mapper.map(optional.get(), TweetModel.class);
		}
		//TODO app specific exception
		else {
			throw new RuntimeException("tweet with given id: "+id+" not found.");
		}
	}

	@PostMapping
	public Tweet tweet(@RequestBody TweetModel model) {
		Tweet tweet = mapper.map(model, Tweet.class);
		return service.create(tweet);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("{id}/comments")
	public List<CommentModel> getComments(@PathVariable Long id) {
		return commentService.getComments(id);
	}

}
