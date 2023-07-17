package com.example.demo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	Optional<User> findByUsername(String username);
	Optional<User> findById(long id);
	User getUserByUsername(String username);

}
