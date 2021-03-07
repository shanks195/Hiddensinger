package com.theplayer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theplayer.entity.LogEntity;

@Repository
public interface LogRepository extends JpaRepository<LogEntity, Long>{
	
	List<LogEntity> findAllBySongId(Long songId);
}
