package com.zhtian.dao;

import com.zhtian.entities.User;

import org.springframework.jdbc.support.KeyHolder;

import java.util.Set;

public interface UserDao {
	public User findById(Integer id);
	public User findByUsername(String username);

	public Set<String> findRoles(String username);
}
