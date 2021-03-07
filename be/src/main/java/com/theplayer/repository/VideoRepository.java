package com.theplayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.theplayer.entity.VideoEntity;

public interface VideoRepository extends JpaRepository<VideoEntity, Long>{
	VideoEntity findOneById(Long id);
	List<VideoEntity> findAllByName(String name);

}