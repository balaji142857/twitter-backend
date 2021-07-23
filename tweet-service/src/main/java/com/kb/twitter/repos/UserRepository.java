package com.kb.twitter.repos;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.kb.twitter.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	
	List<User> findByIdIn(List<String> values);
}
