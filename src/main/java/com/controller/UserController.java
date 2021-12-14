package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.model.User;
import com.security.JwtUtil;
import com.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/users")
	public String selectAll() {
		return new Gson().toJson(userService.selectAll());
	}

	@GetMapping("/users/{id}")
	public String userById(@PathVariable("id") Integer id) {
		User u = userService.selectUserById(id);
		String token = jwtUtil.generateToken(u);
		return token;
	}

//	@GetMapping("/users/{id}")
//	public String userById(@PathVariable("id") Integer id) {
//		return new Gson().toJson(userService.selectUserById(id));
//	}

	@DeleteMapping("/users/{id}")
	public String deleteUserById(@PathVariable("id") Integer id) {
		userService.deleteUserById(id);
		return "deleted";
	}

	@PostMapping("/users")
	public String createUser(@RequestParam("name") String name) {
		userService.createUser(name);
		return "created";
	}
}
