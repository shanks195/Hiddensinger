package com.theplayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.converter.VideoConverter;
import com.theplayer.dto.VideoDTO;
import com.theplayer.entity.SongEntity;
import com.theplayer.entity.VideoEntity;
import com.theplayer.repository.VideoRepository;
import com.theplayer.service.IVideoService;



@Service
public class VideoService implements IVideoService {
	
	@Autowired
	private VideoRepository videoRepository;
	
	
	
	@Autowired
	private VideoConverter videoConverter;

	@Override
	public VideoEntity save(VideoEntity entity) {
		// TODO Auto-generated method stub
		return videoRepository.save(entity);
	}
	@Override
	public List<VideoEntity> findAll(Pageable pageable) {
		List<VideoEntity> entitys = videoRepository.findAll(pageable).getContent();
		return entitys;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return (int) videoRepository.count();
	}

	@Override
	public List<VideoEntity> findAll() {
		// TODO Auto-generated method stub
		return videoRepository.findAll();
	}
	@Override
	public List<VideoEntity> findAllByName(String name) {
		// TODO Auto-generated method stub
		return videoRepository.findAllByName(name);
	}
	@Override
	public VideoEntity findOneById(Long id) {
		return videoRepository.findOneById(id);
	}
	@Override
	public void delete(long[] ids) {
		for(Long id : ids) {
			videoRepository.deleteById(id);
		}
	}
}
