package com.kb.twitter.web.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kb.twitter.web.model.CommentModel;

@FeignClient("comment-service")
public interface CommentClient {

	@GetMapping("comments")
	public List<CommentModel> getComments(@RequestParam("tweetId") Long id);
	
}
