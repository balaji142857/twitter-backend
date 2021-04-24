package com.kb.twitter.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kb.twitter.entity.Tweet;
import com.kb.twitter.repos.TweetRepository;
import com.kb.twitter.service.TweetService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TweetServiceImpl implements TweetService {

	private TweetRepository repo;

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public List<Tweet> list() {
		//TODO use entity mappers -- entity is now sent directly
		Iterable<Tweet> iterable = repo.findAll();
		return null == iterable.iterator() ? Collections.emptyList()
				: StreamSupport
						.stream(Spliterators.spliteratorUnknownSize(iterable.iterator(), Spliterator.ORDERED), false)
						.collect(Collectors.toList());
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Tweet create(Tweet tweet) {
		return repo.save(tweet);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delete(Long id) {
		repo.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	public Optional<Tweet> get(Long id) {
		return repo.findById(id);
	}

}
