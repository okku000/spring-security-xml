package com.model;

public class User {
	private Integer id;
	private String name;
	private String role;

	public User() {
	}

	public User(Integer id, String name, String role) {
		this.id = id;
		this.name = name;
		this.role = role;
	};

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	};

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return "User1(id=" + this.getId() + ", name=" + this.getName() + ", role=" + this.getRole() + ")";
	}
}
