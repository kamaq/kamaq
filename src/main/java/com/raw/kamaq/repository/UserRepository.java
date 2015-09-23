package com.raw.kamaq.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.raw.kamaq.model.User;

public interface UserRepository {

	Collection<User> findByName(String name) throws DataAccessException;

	User findById(int id) throws DataAccessException;

	void save(User user) throws DataAccessException;

	Collection<User> findByNameAndPassword(String name, String password) throws DataAccessException;
}
