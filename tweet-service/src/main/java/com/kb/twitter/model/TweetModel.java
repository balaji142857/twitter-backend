package com.kb.twitter.model;

import java.util.Date;

import lombok.Data;

@Data
public class TweetModel {
	private Long id;
	private Long author;
	private Date createdDate;
	private String tweet;
}
