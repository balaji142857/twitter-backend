package com.kb.twitter.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("comments")
//@AllArgsConstructor
//@RefreshScope
public class CommentsController {
	
	@Value("${max.comments:999}")
	private Long maxComments;
	
	
	@GetMapping()
	public String test() {
		return "hello world";
	}
	
	@GetMapping("/test")
	public Long testValue() {
		return maxComments;
	}

//	private CommentService service;
//
//	private ModelMapper mapper;
//
//	@GetMapping()
//	public List<CommentModel> list(@RequestParam(name = "tweetId") Long tweetId) {
//		return service.list(tweetId)
//				.stream()
//				.map(entity -> mapper.map(entity, CommentModel.class))
//				.collect(Collectors.toList());
//	}
//
//	@PostMapping
//	public CommentModel comment(@RequestBody CommentModel model) {
//		Comment comment = mapper.map(model, Comment.class);
//		return mapper.map(service.save(comment), CommentModel.class);
//	}

}
