package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public User selectUserById(int id) {
		return userDao.selectUserById(id);
	}

	public List<User> selectAll() {
		return userDao.selectAll();
	}

	public int deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}

	public int createUser(String name) {
		return userDao.createUser(name);
	}

	public User findByUserName(String name) {
		return userDao.findByUserName(name);
	}
}
