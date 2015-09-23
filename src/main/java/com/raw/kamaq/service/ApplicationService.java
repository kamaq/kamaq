package com.raw.kamaq.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.raw.kamaq.model.Module;
import com.raw.kamaq.model.User;

public interface ApplicationService {

	public Collection<User> authenticateUser(String username, String password) throws DataAccessException;

	public void saveUser(User user) throws DataAccessException;

	public void saveModule(Module module) throws DataAccessException;

	public User findUserById(int id) throws DataAccessException;

	public Module findModuleById(int id) throws DataAccessException;
}
