package br.com.fiap.dao;

public interface GenericDAO<T,K> {
	
	void insert(T entity);
	T findById(K id);
}
