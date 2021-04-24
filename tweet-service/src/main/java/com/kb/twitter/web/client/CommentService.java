package com.kb.twitter.web.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "comments",url = "http://comment-service/")
public interface CommentService {

	
}
