package com.raw.kamaq.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.raw.kamaq.model.Component;
import com.raw.kamaq.model.Module;
import com.raw.kamaq.model.User;
import com.raw.kamaq.repository.ComponentRepository;
import com.raw.kamaq.repository.ModuleRepository;
import com.raw.kamaq.repository.UserRepository;

@Service
public class ApplicationServiceImpl implements ApplicationService {

	private UserRepository userRepository;
	private ModuleRepository moduleRepository;
	private ComponentRepository componentRepository;

	@Autowired
	public ApplicationServiceImpl(UserRepository userRepository, ModuleRepository moduleRepository,
			ComponentRepository componentRepository) {

		this.userRepository = userRepository;
		this.moduleRepository = moduleRepository;
		this.componentRepository = componentRepository;
	}

	@Override
	public Collection<Module> getModuleList() throws DataAccessException {
		return this.moduleRepository.getListAllModules();
	}

	@Override
	public Collection<Component> getComponentList() throws DataAccessException {
		return this.componentRepository.getListAllComponents();
	}

	@Override
	public Collection<User> authenticateUser(String username, String password) throws DataAccessException {
		return this.userRepository.findByNameAndPassword(username, password);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) throws DataAccessException {
		this.userRepository.save(user);
	}

	@Override
	@Transactional
	public void saveModule(Module module) throws DataAccessException {
		this.moduleRepository.save(module);
	}

	@Override
	@Transactional(readOnly = true)
	public User findUserById(int id) throws DataAccessException {
		return this.userRepository.findById(id);
	}

	@Override
	public Module findModuleById(int id) throws DataAccessException {
		return this.moduleRepository.findById(id);
	}

}
