package com.raw.kamaq.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.raw.kamaq.model.Module;
import com.raw.kamaq.repository.ModuleRepository;

@Repository
public class JpaModuleRepositoryImpl implements ModuleRepository {

	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Module> findByName(String name) {
		Query query = this.em.createQuery("SELECT DISTINCT module FROM Module module where module.name like :name ");
		query.setParameter("name", name + "%");
		return query.getResultList();
	}

	@Override
	public Module findById(int id) {
		Query query = this.em.createQuery("SELECT module from Module module where module.id =:id");
		query.setParameter("id", id);
		return (Module) query.getSingleResult();
	}

	@Override
	public void save(Module module) {
		this.em.merge(module);
	}

}
