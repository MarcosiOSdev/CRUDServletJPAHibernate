package br.com.marcos.repository;

import java.io.Serializable;
import java.util.List;

public interface RepositoryDAO <T, ID extends Serializable> {
	
	public abstract void save(T obj);
	public abstract T update(T obj);
	public abstract void delete(T obj);
	public abstract T findByID(Integer id);
	public abstract List<T> findAll();

}
