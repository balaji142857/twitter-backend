package com.kb.twitter.web;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kb.twitter.entity.Comment;
import com.kb.twitter.service.CommentService;
import com.kb.twitter.web.model.CommentModel;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("comments")
@AllArgsConstructor
public class CommentsController {

	private CommentService service;

	private ModelMapper mapper;

	@GetMapping()
	public List<CommentModel> list(@RequestParam(name = "tweetId") Long tweetId) {
		return service.list(tweetId)
				.stream()
				.map(entity -> mapper.map(entity, CommentModel.class))
				.collect(Collectors.toList());
	}

	@PostMapping
	public CommentModel comment(@RequestBody CommentModel model) {
		Comment comment = mapper.map(model, Comment.class);
		return mapper.map(service.save(comment), CommentModel.class);
	}

}
