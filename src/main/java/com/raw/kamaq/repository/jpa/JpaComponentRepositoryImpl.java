package com.raw.kamaq.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.raw.kamaq.model.Component;
import com.raw.kamaq.repository.ComponentRepository;

@Repository
public class JpaComponentRepositoryImpl implements ComponentRepository{

		@PersistenceContext
		private EntityManager em;


		@Override
		public Component findById(int id) {
			Query query = this.em.createQuery("SELECT component from Component component where component.id =:id");
			query.setParameter("id", id);
			return (Component) query.getSingleResult();
		}

		@Override
		public void save(Component component) {
			this.em.merge(component);
		}
		
		@Override
		public Collection<Component> getListAllComponents() {
			Query query = this.em.createQuery("SELECT component FROM Component component ");
			return query.getResultList();
		}


	}

