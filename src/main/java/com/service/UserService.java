package com.service;

import java.util.List;

import com.model.User;

public interface UserService {
	User selectUserById(int id);

	List<User> selectAll();

	int deleteUserById(int id);

	int createUser(String name);

	User findByUserName(String name);
}
