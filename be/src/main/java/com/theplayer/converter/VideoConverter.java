package com.theplayer.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.theplayer.dto.VideoDTO;
import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.UserEntity;
import com.theplayer.entity.VideoEntity;
import com.theplayer.service.IAccountService;
import com.theplayer.service.IUserService;
import com.theplayer.service.IVideoService;


@Component
public class VideoConverter {
	
	@Autowired
	private IVideoService videoService;
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IUserService userService;
	public 	VideoDTO toDTO(VideoEntity entity) {
		VideoDTO dto = new VideoDTO();
		dto.setId(entity.getId());
		UserEntity user = entity.getUser();
		if(user!=null) {
			AccountEntity account = accountService.findById(user.getAccount().getId());
			dto.setFullname(entity.getUser().getFullName());
			dto.setUsername(account.getUsername());
		}
		dto.setName(entity.getName());
		dto.setUrl(entity.getUrl());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	public VideoEntity toEntity(VideoDTO dto) {
		VideoEntity entity = new VideoEntity();
		AccountEntity account = accountService.findOneByUsername(dto.getUsername());
		UserEntity user = userService.findOneByAccountId(account.getId());
		entity.setUser(user);
		
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		return entity;
	}
	


	
	
	
}