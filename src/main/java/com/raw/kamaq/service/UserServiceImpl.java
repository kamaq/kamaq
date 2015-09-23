package com.raw.kamaq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raw.kamaq.model.Module;
import com.raw.kamaq.model.User;
import com.raw.kamaq.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User authenticate(String username, String password) throws DataAccessException {
		return null;
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) throws DataAccessException {
		userRepository.saveUser(user);
	}

	@Override
	@Transactional
	public void saveModule(Module module) throws DataAccessException {
		userRepository.saveModule(module);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(int id) throws DataAccessException {
		return userRepository.findById(id);
	}

}
