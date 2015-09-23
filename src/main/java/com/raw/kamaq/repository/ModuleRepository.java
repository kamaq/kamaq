package com.raw.kamaq.repository;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.raw.kamaq.model.Module;

public interface ModuleRepository {

	Collection<Module> findByName(String name) throws DataAccessException;

	Module findById(int id) throws DataAccessException;

	void save(Module module) throws DataAccessException;

}
