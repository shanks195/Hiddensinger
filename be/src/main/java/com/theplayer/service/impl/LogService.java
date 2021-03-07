package com.theplayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.entity.LogEntity;
import com.theplayer.repository.LogRepository;
import com.theplayer.service.ILogService;

@Service
public class LogService implements ILogService{
	
	@Autowired
	private LogRepository logRepository;

	@Override
	public LogEntity save(LogEntity entity) {
		// TODO Auto-generated method stub
		return logRepository.save(entity);
	}

	@Override
	public List<LogEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return logRepository.findAll(pageable).getContent();
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) logRepository.count();
	}

	@Override
	public List<LogEntity> findAll() {
		// TODO Auto-generated method stub
		return logRepository.findAll();
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		for(long id : ids) {
			logRepository.deleteById(id);
		}
	}

	@Override
	public List<LogEntity> findAllBySongId(Long songId) {
		// TODO Auto-generated method stub
		return logRepository.findAllBySongId(songId);
	}

}
