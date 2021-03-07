package com.theplayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.entity.CategoryEntity;
import com.theplayer.repository.CategoryRepository;
import com.theplayer.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public CategoryEntity save(CategoryEntity entity) {
		// TODO Auto-generated method stub
		return categoryRepository.save(entity);
	}

	@Override
	public List<CategoryEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CategoryEntity> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoryEntity findOneByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findOneByName(name);
	}

	@Override
	public CategoryEntity findOneById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findOneById(id);
	}

}
