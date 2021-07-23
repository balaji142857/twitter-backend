package com.kb.twitter.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kb.twitter.entity.Tweet;

@Repository
public interface TweetRepository extends MongoRepository<Tweet, String> {

}
