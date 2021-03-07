package com.theplayer.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.theplayer.dto.RatingDTO;
import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.RatingEntity;
import com.theplayer.entity.UserEntity;
import com.theplayer.service.IAccountService;
import com.theplayer.service.IRatingService;
import com.theplayer.service.ISongService;
import com.theplayer.service.IUserService;

@Component
public class RatingConverter {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private ISongService songService;
	
	@Autowired
	private IRatingService ratingService;
	
	public RatingEntity toEntity(RatingDTO dto) {
		RatingEntity entity = new RatingEntity();
		UserEntity user = userService.findOneByAccountId(accountService.findIdAccountByUserName(dto.getUsername()));
		RatingEntity ratingDB = ratingService.findBySongIdAndUserId(dto.getSongId(), user.getId());
		if(ratingDB!=null) {
			entity.setId(ratingDB.getId());
		}else {
			entity.setId(dto.getId());
		}
		entity.setSong(songService.findOneById(dto.getSongId()));
		entity.setUser(user);
		entity.setSubRating(dto.getSubRating());
		return entity;
	}
	
	public RatingDTO toDTO(RatingEntity entity) {
		RatingDTO dto = new RatingDTO();
		dto.setId(entity.getId());
		dto.setSongId(entity.getSong().getId());
		dto.setSubRating(entity.getSubRating());
		AccountEntity account = accountService.findById(entity.getUser().getAccount().getId());
		dto.setUsername(account.getUsername());
		return dto;
	}
}
