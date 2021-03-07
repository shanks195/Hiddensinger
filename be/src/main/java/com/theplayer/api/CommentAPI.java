package com.theplayer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theplayer.converter.CommentConverter;
import com.theplayer.dto.CommentDTO;
import com.theplayer.entity.CommentEntity;
import com.theplayer.service.ICommentService;

@RestController
@RequestMapping(value = "/api/comment")
@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
public class CommentAPI {
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private CommentConverter commentConverter;
	
	@PostMapping
	public CommentEntity postMethodName(@RequestBody CommentDTO dto) {
		CommentEntity entity = commentConverter.toEntity(dto);
		return commentService.save(entity);
	}
	
	@GetMapping
	public List<CommentDTO> getMethodName(@RequestParam (value = "songid", required = true) Long songId) {
		List<CommentDTO> dtos = new ArrayList<>();
		List<CommentEntity> entitys = commentService.findAllBySongIdOrderByCreatedDateDesc(songId);
		for(CommentEntity entity : entitys) {
			dtos.add(commentConverter.toDTO(entity));
		}
		return dtos;
	}

}
