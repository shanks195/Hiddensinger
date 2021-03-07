package com.theplayer.service;

import java.util.List;

import com.theplayer.entity.LogEntity;

public interface ILogService extends AbstractService<LogEntity>{
	
	List<LogEntity> findAllBySongId(Long songId);

}
