package com.theplayer.service;

import com.theplayer.entity.CategoryEntity;

public interface ICategoryService extends AbstractService<CategoryEntity>{
	CategoryEntity findOneByName(String name);
	CategoryEntity findOneById(Long id);
}
