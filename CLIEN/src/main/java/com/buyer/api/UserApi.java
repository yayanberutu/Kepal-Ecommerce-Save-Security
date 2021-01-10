package com.buyer.api;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.buyer.model.User;


@Service
public class UserApi {
	@Autowired RestTemplate restTemplate;
	
	@Value(value = "${base.url}")
	private String url;	
	
	public User getUserByUsername(String username) {
		User user = restTemplate.getForObject(url + "get-user/{username}", User.class, username);
		return user;
	}
	
	public void addUser(User user) {
		restTemplate.postForObject(url + "user/add", user, User.class);
	}
	
	
}
