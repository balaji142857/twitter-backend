package com.kb.twitter.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kb.twitter.entity.Tweet;

@Repository
public interface TweetRepository extends PagingAndSortingRepository<Tweet, Long> {

}
