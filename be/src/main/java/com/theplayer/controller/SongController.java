package com.theplayer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.theplayer.converter.SongConverter;
import com.theplayer.dto.SongDTO;
import com.theplayer.entity.SongEntity;
import com.theplayer.service.impl.AccountService;
import com.theplayer.service.impl.SongService;

@RestController
@RequestMapping("/api/studio/song")
public class SongController {

		@Autowired
		private SongService songService;

		@Autowired
		private SongConverter songConverter;
		
		@Autowired 
		private AccountService accountService;

		@PostMapping(value = "/save")
		public SongDTO postMethodSave(@RequestBody SongDTO dto) {
			SongEntity entity = songConverter.toEntity(dto);
			songService.save(entity);
			return songConverter.toDTO(entity);
		}

		@GetMapping(value = "/list")
		public List<SongDTO> getListSong(@RequestParam String username) {
			Long idaccount= accountService.findIdAccountByUserName(username);
			List<SongEntity> listEntity = songService.findByAccountId(idaccount);
			List<SongDTO> listDTO =new ArrayList<SongDTO>();
			for (SongEntity entity : listEntity) {
				SongDTO dto = songConverter.toDTO(entity);
				listDTO.add(dto);
			}
			return listDTO;
		}
		
		@GetMapping(value = "/detail")
		public SongDTO getMethodName(@RequestParam Long id) {
			return songConverter.toDTO(songService.findOneById(id));
		}
		@PostMapping(value = "/delete")
		public SongEntity deleteEntity(@RequestBody SongEntity entity) {
			return songService.deleteSongId(entity.getId());
		}

	

}
