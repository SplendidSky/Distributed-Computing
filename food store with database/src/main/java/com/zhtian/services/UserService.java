package com.zhtian.services;

import com.zhtian.entities.User;

import java.util.Set;

public interface UserService {
	public User findById(Integer id);


	public User findByUsername(String username);

	public Set<String> findRoles(String username);

}
