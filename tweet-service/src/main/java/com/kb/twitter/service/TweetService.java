package com.kb.twitter.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kb.twitter.entity.Tweet;
import com.kb.twitter.entity.User;
import com.kb.twitter.repos.TweetRepository;
import com.kb.twitter.repos.UserRepository;
import com.kb.twitter.web.model.TweetModel;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class TweetService {

	@Autowired
	private TweetRepository repo;
	@Autowired
	private UserRepository users;

	public List<TweetModel> list() {
		List<Tweet> tweets = repo.findAll();
		log.info("tweets {} found", tweets);
		List<String> authors = tweets.stream().map(Tweet::getAuthorId).distinct().collect(Collectors.toList());
		log.info("tweet authors {}", authors);
		Map<String, User> userMap = users.findByIdIn(authors).stream()
				.collect(Collectors.toMap(User::getId, Function.identity()));
		log.info("users collection {}", userMap.values());
		List<TweetModel> returnValue = tweets.stream().map(tweet -> model(tweet, userMap.get(tweet.getAuthorId())))
				.collect(Collectors.toList());
		log.info("model value {}", returnValue);
		return returnValue;
	}
	
	public List<User> getUsers() {
		return users.findAll();
	}

	public void create(TweetModel model) {
		log.info("processing creation request {}", model);
		repo.save(Tweet.builder()
				.tweetMessage(model.getTweetMessage())
				.authorId("60e048af4639b08f9d3c40a7")
				.build());
	}

	private TweetModel model(Tweet entity, User author) {
		TweetModel model = new TweetModel();
		if (null != author) {
			model.setAuthorDp(author.getDpPath());
			model.setAuthorHandle(author.getHandle());
			model.setAuthorName(author.getName());
			model.setAuthorVerified(author.isVerified());
		}
		model.setComments(null);
		model.setLikes(null);
		model.setRetweets(null);
		model.setIssuedTime(new ObjectId(entity.getId()).getDate());
		model.setTweetMessage(entity.getTweetMessage());
		return model;
	}

}
