package com.theplayer.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.theplayer.dto.CommentDTO;
import com.theplayer.dto.RoleDTO;
import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.CommentEntity;
import com.theplayer.entity.RoleEntity;
import com.theplayer.entity.SongEntity;
import com.theplayer.service.IAccountService;
import com.theplayer.service.ISongService;
import com.theplayer.service.IUserService;


@Component
public class CommentConverter {
	
	@Autowired
	private ISongService songService;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IUserService userService;
	
	public CommentEntity toEntity(CommentDTO dto) {
		CommentEntity entity = new CommentEntity();
		entity.setId(dto.getId());
		entity.setSong(songService.findOneById(dto.getSongId()));
		AccountEntity account = accountService.findOneByUsername(dto.getUsername());
		entity.setUser(userService.findOneByAccountId(account.getId()));
		entity.setContent(dto.getContent());
		return entity;
		
	}
	
	public CommentDTO toDTO(CommentEntity entity) {
		CommentDTO dto = new CommentDTO();
		dto.setId(entity.getId());
		dto.setUsername(accountService.findById(entity.getUser().getAccount().getId()).getUsername());
		dto.setSongId(entity.getSong().getId());
		dto.setContent(entity.getContent());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
}
