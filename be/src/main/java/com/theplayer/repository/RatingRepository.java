package com.theplayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theplayer.entity.RatingEntity;

@Repository
public interface RatingRepository extends JpaRepository<RatingEntity, Long> {
	
	List<RatingEntity> findAllBySubRatingAndSongId(String subRating, Long songId);

	RatingEntity findBySongIdAndUserId(Long songId, Long userId);
	
	List<RatingEntity> findAllByUserId(Long userId);
}
