package com.theplayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.entity.CommentEntity;
import com.theplayer.repository.CommentRepository;
import com.theplayer.service.ICommentService;

@Service
public class CommentService implements ICommentService{
	
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public CommentEntity save(CommentEntity entity) {
		return commentRepository.save(entity);
	}

	@Override
	public List<CommentEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<CommentEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long[] ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CommentEntity> findAllBySongIdOrderByCreatedDateDesc(Long songId) {
		return commentRepository.findAllBySongIdOrderByCreatedDateDesc(songId);
	}
}
