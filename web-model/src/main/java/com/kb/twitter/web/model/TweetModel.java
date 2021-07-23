package com.kb.twitter.web.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class TweetModel implements Serializable {
	private static final long serialVersionUID = -6684656615838244472L;
	private String authorName;
    private boolean isAuthorVerified;
    private String authorHandle;
    private Date issuedTime;
    private String authorDp;
    private String tweetMessage;
    private Long likes;
    private Long retweets;
    private Long comments;
}
