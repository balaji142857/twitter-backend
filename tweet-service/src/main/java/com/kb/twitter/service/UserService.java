package com.kb.twitter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kb.twitter.entity.User;
import com.kb.twitter.repos.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository repo;

	public List<User> list() {
		return repo.findAll();		
	}

}
