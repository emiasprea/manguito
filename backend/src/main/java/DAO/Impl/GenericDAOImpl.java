package DAO.Impl;

import java.util.List;

import DAO.GenericDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import lombok.Getter;

@Getter
public class GenericDAOImpl<T> implements GenericDAO<T>{
	
	protected Class<T> persistentClass;
	public GenericDAOImpl(Class<T> clase) {
		persistentClass = clase;
	}
	
	private Class<T> getPersistentClass(){
		return this.persistentClass;
	}
	
	private static EntityManager manager;
	private static EntityManagerFactory emf;
	
	
	@Override
	public T save (T entity) {
		emf = Persistence.createEntityManagerFactory("manguito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(entity);
			tx.commit();
		} catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e;
		} finally {
			em.close();
		}
		return entity;
	} 

	@Override
	public T deleteById (Long id) {
		emf = Persistence.createEntityManagerFactory("manguito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		T entity =em.find(this.getPersistentClass(), id);
		if (entity != null) {
			em.remove(entity);
		}
		em.close();
		return entity;
	} 
	
	@Override
	public void delete (T entity) {
		emf = Persistence.createEntityManagerFactory("manguito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(entity));
			tx.commit();
		}catch (RuntimeException e) {
			if ( tx != null && tx.isActive() ) tx.rollback();
			throw e;
		} finally {
			em.close();
		}
	} 
	
	public List<T> getAll (String column){
		emf = Persistence.createEntityManagerFactory("manguito");
		EntityManager em = emf.createEntityManager();
		Query consulta = em.createQuery("select e from "+ getPersistentClass().getSimpleName()+" e order by e."+column);
		List<T> resultado = (List<T>) consulta.getResultList();
		return resultado;
	}
	
	public T getById (Long id) {
		emf = Persistence.createEntityManagerFactory("manguito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		T entity =em.find(this.getPersistentClass(), id);
		return entity;
	}
	
	public T update (T entity) {
		emf = Persistence.createEntityManagerFactory("manguito");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = null;
		tx = em.getTransaction();
		tx.begin();
		T entityUpdated = em.merge(entity);
		tx.commit();
		em.close();
		return entityUpdated;
	}
	
}
