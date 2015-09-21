package com.raw.kamaq.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.raw.kamaq.model.User;
import com.raw.kamaq.repository.UserRepository;

@Repository
public class JpaUserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<User> findByName(String name) throws DataAccessException {
		Query query = this.em.createQuery("SELECT DISTINCT user FROM User user where user.name like :name ");
		query.setParameter("name", name + "%");
		return query.getResultList();
	}

	@Override
	public User findById(int id) throws DataAccessException {
		Query query = this.em.createQuery("SELECT user from User user where user.id =:id");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	@Override
	public void saveUser(User user) throws DataAccessException {
		this.em.merge(user);
	}

}
