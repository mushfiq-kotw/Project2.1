package com.example.demo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		      User user = userRepository.getUserByUsername(username);
		      List<String> roles = user.getRoles().stream().map(role ->role.getName()).collect(Collectors.toList());
			
			UserDetails usede = org.springframework.security.core.userdetails.User
			.withDefaultPasswordEncoder().username(user.getUsername()).password(user.getPassword())
			.roles(roles.toArray(new String[] {})).build();
			return usede;
	}
	
}
