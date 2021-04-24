package com.kb.twitter.model;

import java.util.Date;

import lombok.Data;

@Data
public class CommentModel {

	private Long id;
	private Long tweet;
	private Long author;
	private String comment;
	private Date commentedDate;
}
