package com.kb.twitter.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Comment {
	
	@Id
	@GeneratedValue
	private Long id;
	private Long tweet;
	private Long author;
	private String comment;
	private Date commentedDate;

}
