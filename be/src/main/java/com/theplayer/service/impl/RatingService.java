package com.theplayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.entity.RatingEntity;
import com.theplayer.repository.RatingRepository;
import com.theplayer.service.IRatingService;

@Service
public class RatingService implements IRatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public RatingEntity save(RatingEntity entity) {
		return ratingRepository.save(entity);
	}

	@Override
	public List<RatingEntity> findAll(Pageable pageable) {
		return ratingRepository.findAll(pageable).getContent();
	}

	@Override
	public int totalItem() {
		return (int) ratingRepository.count();
	}

	@Override
	public List<RatingEntity> findAll() {
		return ratingRepository.findAll();
	}

	@Override
	public void delete(long[] ids) {
		for(Long id : ids) {
			ratingRepository.deleteById(id);
		}
	}

	@Override
	public List<RatingEntity> findAllBySubRatingAndSongId(String subRating, Long songId) {
		return ratingRepository.findAllBySubRatingAndSongId(subRating, songId);
	}

	@Override
	public RatingEntity findBySongIdAndUserId(Long songId, Long userId) {
		return ratingRepository.findBySongIdAndUserId(songId, userId);
	}

	@Override
	public Long sumLikeBySongId(Long songId) {
		return (long) findAllBySubRatingAndSongId("like", songId).size();
	}

	@Override
	public Long sumDislikeBySongId(Long songId) {
		return (long) findAllBySubRatingAndSongId("dislike", songId).size();
	}

	@Override
	public List<RatingEntity> findAllByUserId(Long userId) {
		// TODO Auto-generated method stub
		return ratingRepository.findAllByUserId(userId);
	}

}
