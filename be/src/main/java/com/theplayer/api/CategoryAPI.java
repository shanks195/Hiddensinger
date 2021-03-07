package com.theplayer.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theplayer.entity.CategoryEntity;
import com.theplayer.service.ICategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryAPI {
	
	@Autowired
	private ICategoryService categoryService;
	
	@PostMapping
	public CategoryEntity postMethodName(@RequestBody CategoryEntity entity) {
		//TODO: process POST request
		
		return categoryService.save(entity);
	}
	
	@GetMapping("/get")
	public List<CategoryEntity> getCategory() {
		List<CategoryEntity> listEntity = categoryService.findAll();
		return listEntity;
	}


}
