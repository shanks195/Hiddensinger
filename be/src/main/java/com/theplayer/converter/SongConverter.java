package com.theplayer.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.theplayer.dto.SongDTO;
import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.SongEntity;
import com.theplayer.entity.UserEntity;
import com.theplayer.service.IAccountService;
import com.theplayer.service.ICategoryService;
import com.theplayer.service.IRatingService;
import com.theplayer.service.ISongService;
import com.theplayer.service.IUserService;

@Component
public class SongConverter {
	
	@Autowired
	private ICategoryService categoryService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IRatingService ratingService;
	
	@Autowired
	private ISongService songService;
	
	public SongDTO toDTO(SongEntity entity) {
		SongDTO dto = new SongDTO();
		UserEntity user = entity.getUser();
		if(user!=null) {
			AccountEntity account = accountService.findById(user.getAccount().getId());
			dto.setFullname(entity.getUser().getFullName());
			dto.setUsername(account.getUsername());
		}
		if(entity.getCategory()!=null) {
			dto.setCategoryName(categoryService.findOneById(entity.getCategory().getId()).getName());
		}
		dto.setLikes(ratingService.sumLikeBySongId(entity.getId()));
		dto.setDislikes(ratingService.sumDislikeBySongId(entity.getId()));
		dto.setScore(songService.sumScoreSong(entity.getId()));
		dto.setId(entity.getId());
		dto.setLyric(entity.getLyric());
		dto.setName(entity.getName());
		dto.setUrl(entity.getUrl());
		dto.setViews(entity.getViews());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
	public SongEntity toEntity(SongDTO dto) {
		SongEntity entity = new SongEntity();
		AccountEntity account = accountService.findOneByUsername(dto.getUsername());
		UserEntity user = userService.findOneByAccountId(account.getId());
		entity.setUser(user);
		if(dto.getCategoryName()!=null) {
			entity.setCategory(categoryService.findOneByName(dto.getCategoryName()));
		}
		if(dto.getId()!=null) {
			entity.setLikes(ratingService.sumLikeBySongId(entity.getId()));
			entity.setDislikes(ratingService.sumDislikeBySongId(entity.getId()));
		}
		entity.setId(dto.getId());
		entity.setLyric(dto.getLyric());
		entity.setName(dto.getName());
		entity.setUrl(dto.getUrl());
		entity.setViews(dto.getViews());
		return entity;
	}
}
