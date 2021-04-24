package com.kb.twitter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

import lombok.Data;

@Entity
@Data
public class Tweet {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long author;
	private String tweet;
	@CreatedDate
	private Date createdDate;
//	private TweetMetadata metadata;

}
