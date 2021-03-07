package com.theplayer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theplayer.converter.RatingConverter;
import com.theplayer.dto.RatingDTO;
import com.theplayer.entity.RatingEntity;
import com.theplayer.entity.UserEntity;
import com.theplayer.service.IAccountService;
import com.theplayer.service.IRatingService;
import com.theplayer.service.IUserService;

@CrossOrigin
@RestController
@RequestMapping("/api/rating")
public class RatingAPI {
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private IRatingService ratingService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private RatingConverter ratingConverter;
	
	@GetMapping
	public List<RatingDTO> getRatingByUsername(@RequestParam (value = "username",required = false) String username) {
		List<RatingEntity> ratings = new ArrayList<>();
		if(username!=null) {
			Long accountId = accountService.findIdAccountByUserName(username);
			UserEntity user = userService.findOneByAccountId(accountId);
			
			if(user!=null) {
				ratings = ratingService.findAllByUserId(user.getId());
			}
		}else {
			ratings = ratingService.findAll();
		}
		List<RatingDTO> dtos = new ArrayList<>();
		for(RatingEntity entity : ratings) {
			dtos.add(ratingConverter.toDTO(entity));
		}
		
		return dtos;
	}
	
	@PostMapping
	public RatingEntity postRating(@RequestBody RatingDTO dto) {
		return ratingService.save(ratingConverter.toEntity(dto));
	}
	
	@DeleteMapping(value = "/{ids}")
	public String deleteRating(@PathVariable long[] ids) {
		//TODO: process DELETE request
		ratingService.delete(ids);
		return "Success";
	}



}
