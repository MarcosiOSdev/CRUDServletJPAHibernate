package br.com.marcos.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T, ID extends Serializable> implements RepositoryDAO<T, ID>{
	
	private final static String UNIT_NAME="TestePU";
	
	protected EntityManager em;
	private Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public GenericDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(T entity){
		em.persist(entity);
	}
	
	protected void delete(Object id, Class<T> classe){
		T entityToBeRemoved = em.getReference(classe, id);
		em.remove(entityToBeRemoved);
	}
	
	public T update(T entity){
		return em.merge(entity);
	}
	
	public T findByID(ID id){
		return em.find(entityClass, id);
	}
	
	// Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }
    
   @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll(int begin, int end) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).setFirstResult(begin).setMaxResults(end).getResultList();
    }
	
}
