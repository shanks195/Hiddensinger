package com.theplayer.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

public interface AbstractService<T> {
	T save(T entity);

	List<T> findAll(Pageable pageable);

	int totalItem();

	List<T> findAll();
	
	void delete(long[] ids);
}
