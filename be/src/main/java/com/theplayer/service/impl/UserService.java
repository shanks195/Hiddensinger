package com.theplayer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.converter.UserConverter;

import com.theplayer.dto.UserDTO;

import com.theplayer.entity.UserEntity;
import com.theplayer.repository.UserRepository;
import com.theplayer.service.IUserService;

@Service
public class UserService implements IUserService{
	
	@Autowired private UserRepository userRepository;
	@Autowired private UserConverter userConverter;
	@Override
	public UserEntity save(UserEntity entity) {
		// TODO Auto-generated method stub
		return userRepository.save(entity);
	}

	@Override
	public List<UserEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserEntity> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}
	
	public List<UserDTO> findAllUserDTO() {
		// TODO Auto-generated method stub
		List<UserDTO> listDTO = new ArrayList<>();
		List<UserEntity> listEntity = userRepository.findAll();
		for(UserEntity entity: listEntity) {
			UserDTO dto = userConverter.toDTO(entity);
			listDTO.add(dto);
		}
		return listDTO;
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}
	public Long findIdUserByIdAccount(Long id){
		UserEntity user = userRepository.findByAccountId(id);
		return user!=null?user.getId():null;
		
	}

	@Override
	public UserEntity findOneByAccountId(Long id) {
		// TODO Auto-generated method stub
		return userRepository.findByAccountId(id);
	}
	
	public List<UserEntity> findPaginated(int pageNo, int pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<UserEntity> pagedResult = userRepository.findAll(paging);
        return pagedResult.toList();
    }

}
