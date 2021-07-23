package com.kb.twitter.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "users")
public class User {
	
	@Id
	private String id;
	private String handle;
	private String name;
	private String dpPath;
	private boolean isVerified;
	private String bio;

}
