package com.springboot.datajpa.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springboot.datajpa.app.models.entity.Cliente;

//@Repository("ClienteDaoJPA") implements IClienteDao
public class ClienteDaoImp_old  {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	
	public List<Cliente> findAll() {
		
		return em.createQuery("from Cliente").getResultList();
	}

	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
	}

	public Cliente findOne(Long id) {		
		return em.find(Cliente.class, id);
	}

	public void delete(Long id) {
		em.remove(findOne(id));		
	}
}
