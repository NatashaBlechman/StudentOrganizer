package com.myschooljournal.dao;

import java.util.Collection;


public interface  CommonDao<T> {
	T save(T object);
	T getById(Long id);
	T remove(Long id);
	Collection<T> getAll();
	T update(Long id, T object);
}
