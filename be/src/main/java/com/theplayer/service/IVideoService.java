package com.theplayer.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.theplayer.dto.VideoDTO;

import com.theplayer.entity.VideoEntity;

public interface IVideoService {
	List<VideoEntity> findAllByName(String name);
	VideoEntity findOneById(Long id);
	
	void delete(long[] ids);
	List<VideoEntity> findAll(Pageable pageable);
	int totalItem();
	List<VideoEntity> findAll();
	VideoEntity save(VideoEntity entity);
}
