package com.theplayer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.theplayer.api.output.VideoOutput;

import com.theplayer.converter.VideoConverter;
import com.theplayer.dto.SongDTO;
import com.theplayer.dto.VideoDTO;
import com.theplayer.entity.SongEntity;
import com.theplayer.entity.VideoEntity;
import com.theplayer.service.IVideoService;



@CrossOrigin
@RestController
public class VideoAPI {
	@Autowired
	private VideoConverter videoConverter;
	@Autowired
	private IVideoService videoService;

	@PostMapping(value = "/api/video")
	public VideoDTO postMethodName(@RequestBody VideoDTO dto) {
		// TODO: process POST request
		VideoEntity entity = videoConverter.toEntity(dto);
		videoService.save(entity);
		return videoConverter.toDTO(entity);
	}
	@GetMapping(value = "/api/video/list")
	public VideoOutput getListSong(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit) {
		VideoOutput videoOut = new VideoOutput();
		List<VideoDTO> listDTO = new ArrayList<>();
		List<VideoEntity> listEntity = new ArrayList<>();
		if (page != null && limit != null) {
			videoOut.setPage(page);
			videoOut.setTotalPage((int) Math.ceil((double) (videoService.totalItem()) / limit));
			Pageable pageable = PageRequest.of(page - 1, limit);
			listEntity = videoService.findAll(pageable);

		} else {
			listEntity = videoService.findAll();
		}
		for (VideoEntity entity : listEntity) {
			VideoDTO dto = videoConverter.toDTO(entity);
			listDTO.add(dto);
		}
		videoOut.setListResult(listDTO);
		return videoOut;
	}

	@GetMapping(value = "/api/video/detail")
	public VideoDTO getMethodName(@RequestParam Long id) {
		return videoConverter.toDTO(videoService.findOneById(id));
	}
	
//	@PutMapping(value = "/api/video/{id}")
//	public VideoDTO updateVideo(@RequestBody VideoDTO model, @PathVariable("id") long id) {
//		model.setId(id);
//		return videoService.save(model);
//	}
	
	@DeleteMapping(value = "/api/video/{ids}")
	public String deleteVideo(@PathVariable long[] ids) {
		//TODO: process DELETE request
		videoService.delete(ids);
		return "Success";
	}
}