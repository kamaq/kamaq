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
	public Collection<User> findByName(String name) {
		Query query = this.em.createQuery("SELECT DISTINCT user FROM User user where user.name like :name ");
		query.setParameter("name", name + "%");
		return query.getResultList();
	}

	@Override
	public User findById(int id) {
		Query query = this.em.createQuery("SELECT user from User user where user.id =:id");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}

	@Override
	public void save(User user) {
		if (user.getId() == null) {
			// update object user with changes sent to database
			this.em.persist(user);
		} else {
			// no update object user
			this.em.merge(user);
		}

	}

	@Override
	public Collection<User> findByNameAndPassword(String name, String password) throws DataAccessException {
		Query query = this.em
				.createQuery("SELECT user FROM User user WHERE user.name =:name and user.password =:password ");
		query.setParameter("name", name);
		query.setParameter("password", password);
		return query.getResultList();
	}

	@Override
	public Collection<User> getListAllUsers() {
		Query query = this.em.createQuery("SELECT user FROM User user ");
		return query.getResultList();
	}

}
