package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.User;

public interface UserDao {
	User selectUserById(@Param("id") int id);

	List<User> selectAll();

	int deleteUserById(@Param("id") int id);

	int createUser(@Param("name") String name);

	User findByUserName(@Param("name") String name);
}
