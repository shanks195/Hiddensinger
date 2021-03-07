package com.theplayer.service;

import java.util.List;

import com.theplayer.entity.CommentEntity;

public interface ICommentService extends AbstractService<CommentEntity>{
	List<CommentEntity> findAllBySongIdOrderByCreatedDateDesc(Long songId);
}
