package com.kb.twitter.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "tweets")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tweet {
	
	@Id
	private String id;
	private String authorId;
	private String tweetMessage;
	private Long likes;
	private Long retweets;
	private Long quotes;

}
