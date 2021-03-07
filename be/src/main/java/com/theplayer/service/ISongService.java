package com.theplayer.service;

import java.util.List;

import com.theplayer.entity.SongEntity;

public interface ISongService extends AbstractService<SongEntity> {

	List<SongEntity> findAllByName(String name);

	List<SongEntity> findAllOrderByLikesAsc();

	List<SongEntity> findAllOrderByDislikesAsc();
	
	Long sumTopLike();
	
	Long sumTopDislike();
	
	Long sumViewsTop();
	
	Float sumScoreSong(Long songId);
	
	SongEntity findOneById(Long id);
	
	List<SongEntity> findByCategoryId(Long categoryId);
}
