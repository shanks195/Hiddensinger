package com.theplayer.service;

import java.util.List;

import com.theplayer.entity.RatingEntity;

public interface IRatingService extends AbstractService<RatingEntity> {

	List<RatingEntity> findAllBySubRatingAndSongId(String subRating, Long songId);

	RatingEntity findBySongIdAndUserId(Long songId, Long userId);
	
	Long sumLikeBySongId(Long songId);
	
	Long sumDislikeBySongId(Long songId);
	
	List<RatingEntity> findAllByUserId(Long userId);
}
