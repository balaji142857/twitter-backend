package com.kb.twitter.repos;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kb.twitter.entity.Comment;

@Repository
public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {
	
	Iterable<Comment> findByTweet(Long tweetId);

}
