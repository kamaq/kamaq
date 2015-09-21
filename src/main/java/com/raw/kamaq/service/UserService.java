package com.raw.kamaq.service;

import org.springframework.dao.DataAccessException;

import com.raw.kamaq.model.User;

public interface UserService {

	public User authenticate(String username, String password) throws DataAccessException;

	public void saveUser(User user) throws DataAccessException;

	public User findUserById(int id) throws DataAccessException;
}
