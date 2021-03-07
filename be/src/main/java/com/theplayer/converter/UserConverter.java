package com.theplayer.converter;

import com.theplayer.dto.UserDTO;
import com.theplayer.entity.UserEntity;
import com.theplayer.repository.AccountRepository;
import com.theplayer.request.SignupRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    @Autowired private AccountRepository accountRepository;
 
    public UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setId(dto.getId());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setAddress(dto.getAddress());
        entity.setBirthday(dto.getBirthday());
        entity.setGender(dto.getGender());
        entity.setPhone(dto.getPhone());
        entity.setAccount(accountRepository.findOneByUsername(dto.getUsername()));
		return entity;
	}
	
	 public UserDTO toDTO(UserEntity entity) {
		 UserDTO dto = new UserDTO();
	 	dto.setId(entity.getId());
	 	dto.setFullName(entity.getFullName());
	 	dto.setAddress(entity.getAddress());
	 	dto.setBirthday(entity.getBirthday());
	 	dto.setEmail(entity.getEmail());
	 	dto.setGender(entity.getGender());
	 	dto.setPhone(entity.getPhone());
	 	dto.setUsername(accountRepository.findOneById(entity.getId()).getUsername());
	 	dto.setPassword(accountRepository.findOneById(entity.getId()).getPassword());
	 	dto.setActive(accountRepository.findOneById(entity.getId()).getActive());
	 	dto.setCreatedDate(entity.getCreatedDate());
	 	dto.setCreatedBy(entity.getCreatedBy());
	 	dto.setModifiedBy(entity.getModifiedBy());
	 	dto.setModifiedDate(entity.getModifiedDate());
	 	return dto;
	 }
	 public UserEntity requestToEntity(SignupRequest dto) {
			UserEntity entity = new UserEntity();
			entity.setId(dto.getId());
	        entity.setFullName(dto.getFullName());
	        entity.setEmail(dto.getEmail());
	        entity.setGender(dto.getGender());
	        entity.setPhone(dto.getPhone());
	        entity.setAccount(accountRepository.findOneByUsername(dto.getUsername()));
			return entity;
		}
}
