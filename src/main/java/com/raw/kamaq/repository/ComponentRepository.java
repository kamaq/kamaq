package com.raw.kamaq.repository;

import java.util.Collection;
import org.springframework.dao.DataAccessException;
import com.raw.kamaq.model.Component;

public interface ComponentRepository  {
		
		Collection<Component> getListAllComponents() throws DataAccessException;

		Component findById(int id) throws DataAccessException;

		void save(Component component) throws DataAccessException;

	}