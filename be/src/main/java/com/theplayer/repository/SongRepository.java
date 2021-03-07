package com.theplayer.repository;

import java.util.List;


import  org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.theplayer.entity.SongEntity;

@Repository
public interface SongRepository extends JpaRepository<SongEntity, Long> {
	
	List<SongEntity> findAllByName(String name);
	
	List<SongEntity> findByOrderByLikesAsc();
	
	List<SongEntity> findByOrderByDislikesAsc();
	
	List<SongEntity> findByOrderByViewsAsc();
	
	SongEntity findOneById(Long id);
	

	List<SongEntity> findByCategoryId(Long categoryId);

	List<SongEntity>findAllByUserId(Long userId);

}
