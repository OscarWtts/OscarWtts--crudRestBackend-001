package com.jes.crud.commons;

import java.util.List;
import java.io.Serializable;

// Creamos una interface generica ya que nos puede servir luego para 
// cualquier entidad.

public interface GenericServiceAPI <T, ID extends Serializable> {
	
	T save(T entity);

	void delete(ID id);

	T get(ID id);

	List<T> getAll();
}
