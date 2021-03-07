package com.theplayer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.theplayer.converter.RoleConverter;
import com.theplayer.dto.RoleDTO;
import com.theplayer.entity.RoleEntity;
import com.theplayer.service.impl.RoleService;

@RestController
@RequestMapping(path = "/api/role")
public class RoleAPI {
	
	@Autowired
	private RoleConverter roleConverter;
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping
	public RoleEntity postMethodName(@RequestBody RoleDTO dto) {
		//TODO: process POST request
		RoleEntity entity = roleConverter.toEntity(dto);
		roleService.save(entity);
		return entity;
	}

}
