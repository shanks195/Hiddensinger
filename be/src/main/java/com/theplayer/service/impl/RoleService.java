package com.theplayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.entity.RoleEntity;
import com.theplayer.repository.RoleRepository;
import com.theplayer.service.IRoleService;

@Service
public class RoleService implements IRoleService{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public RoleEntity save(RoleEntity entity) {
		// TODO Auto-generated method stub
		return roleRepository.save(entity);
	}

	@Override
	public List<RoleEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RoleEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

}
