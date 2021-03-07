package com.theplayer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.theplayer.converter.PlaylistConverter;
import com.theplayer.dto.PlaylistDTO;
import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.PlaylistEntity;
import com.theplayer.service.IAccountService;
import com.theplayer.service.IPlaylistService;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/playlist")
public class PlaylistAPI {
	
	@Autowired
	private IPlaylistService playlistService;
	
	@Autowired
	private PlaylistConverter playlistConverter;
	
	@Autowired
	private IAccountService accountService;
	
	@PostMapping
	public PlaylistEntity postPlaylist(@RequestBody PlaylistDTO dto) {
		PlaylistEntity entity = playlistConverter.toEntity(dto);
		return playlistService.save(entity);
	}
	
	@GetMapping
	public PlaylistDTO getPlaylists(@RequestParam (value = "username",required = false)String username){
		AccountEntity account = accountService.findOneByUsername(username);
		PlaylistEntity entity = playlistService.findOneByAccountId(account.getId());
		return playlistConverter.toDTO(entity);
	}
	@DeleteMapping(value = "/{username}/{songId}")
	public void deletePlaylist(@PathVariable String username,@PathVariable Long songId) {
		playlistService.deleteSongInPlaylist(username, songId);
	}

}
