//package com.kb.twitter.service.impl;
//
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.StreamSupport;
//
//import org.springframework.stereotype.Service;
//
//import com.kb.twitter.entity.Comment;
//import com.kb.twitter.repos.CommentRepository;
//import com.kb.twitter.service.CommentService;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class CommentServiceImpl implements CommentService {
//
//	private CommentRepository repo;
//	
//	@Override
//	public List<Comment> list(Long tweetId) {
//		log.info("comment list called");
//		return StreamSupport.stream(repo.findByTweet(tweetId).spliterator(), false)
//			.collect(Collectors.toList());
//	}
//
//	@Override
//	public Comment save(Comment comment) {
//		log.info("comment save called");
//		return repo.save(comment);
//	}
//
//}
