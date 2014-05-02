package br.com.marcos.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class GenericDAO<T, ID extends Serializable> implements RepositoryDAO<T, ID>{
	
	private final static String UNIT_NAME="TestePU";
	
	private EntityManager em;
	private Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	public GenericDAO(EntityManager em) {
		this.em = em;
	}
	
	public void save(T entity){
		getEm().persist(entity);
	}
	
	protected void delete(Object id, Class<T> classe){
		T entityToBeRemoved = getEm().getReference(classe, id);
		getEm().remove(entityToBeRemoved);
	}
	
	public T update(T entity){
		return getEm().merge(entity);
	}
	
	public T findByID(ID id){
		return getEm().find(entityClass, id);
	}
	
	// Using the unchecked because JPA does not have a
    // em.getCriteriaBuilder().createQuery()<T> method
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<T> findAll() {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEm().createQuery(cq).getResultList();
    }
    
   @SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll(int begin, int end) {
        CriteriaQuery cq = getEm().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEm().createQuery(cq).setFirstResult(begin).setMaxResults(end).getResultList();
    }

   public EntityManager getEm() {
	   return em;
   }

   public void setEm(EntityManager em) {
	   this.em = em;
   }
	
   
}
