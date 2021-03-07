package com.theplayer.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theplayer.api.output.SongOutput;
import com.theplayer.converter.SongConverter;
import com.theplayer.dto.SongDTO;
import com.theplayer.entity.SongEntity;
import com.theplayer.service.ISongService;

@RestController
@RequestMapping("/api/song")
public class SongAPI {

	@Autowired
	private ISongService songService;

	@Autowired
	private SongConverter songConverter;

	@PostMapping
	public SongDTO postMethodName(@RequestBody SongDTO dto) {
		// TODO: process POST request
		SongEntity entity = songConverter.toEntity(dto);
		songService.save(entity);
		return songConverter.toDTO(entity);
	}

	@GetMapping(value = "/list")
	public SongOutput getListSong(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "categoryid", required = false) Long categoryId) {
		SongOutput songOut = new SongOutput();
		List<SongDTO> listDTO = new ArrayList<>();
		List<SongEntity> listEntity = new ArrayList<>();
		if (page != null && limit != null) {
			songOut.setPage(page);
			songOut.setTotalPage((int) Math.ceil((double) (songService.totalItem()) / limit));
			Pageable pageable = PageRequest.of(page - 1, limit);
			listEntity = songService.findAll(pageable);

		} else if (categoryId != null) {
			listEntity = songService.findByCategoryId(categoryId);
		} else {
			listEntity = songService.findAll();
		}
		for (SongEntity entity : listEntity) {
			SongDTO dto = songConverter.toDTO(entity);
			listDTO.add(dto);
		}
		songOut.setListResult(listDTO);
		return songOut;
	}

	@GetMapping(value = "/detail")
	public SongDTO getMethodName(@RequestParam Long id) {
		return songConverter.toDTO(songService.findOneById(id));
	}

}
