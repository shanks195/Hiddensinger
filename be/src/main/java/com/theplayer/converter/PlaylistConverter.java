package com.theplayer.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.theplayer.dto.PlaylistDTO;
import com.theplayer.dto.SongDTO;
import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.PlaylistEntity;
import com.theplayer.entity.SongEntity;
import com.theplayer.service.IAccountService;
import com.theplayer.service.IPlaylistService;
import com.theplayer.service.ISongService;

@Component
public class PlaylistConverter {
	
	@Autowired
	private IAccountService accountService;
	
	@Autowired
	private ISongService songService;
	
	@Autowired
	private SongConverter songConverter;
	
	@Autowired
	private IPlaylistService playlistService;
	
	public PlaylistEntity toEntity(PlaylistDTO dto) {
		PlaylistEntity entity = new PlaylistEntity();
		entity.setId(dto.getId());
		if(dto.getUsername()!=null) {
			AccountEntity account = accountService.findOneByUsername(dto.getUsername());
			if(account != null) {
				SongEntity song = songService.findOneById(dto.getSongId());
				PlaylistEntity playlist = playlistService.findOneByAccountId(account.getId());
				if(playlist!=null) {
					playlist.getSongs().add(song);
					entity = playlist;
				}else {
					Set<SongEntity> songs = new HashSet<>();
					songs.add(song);
					entity.setAccount(account);
					entity.setSongs(songs);
				}
				
			}else {
				return null;
			}
		}else {
			return null;
		}
		return entity;
	}
	
	public PlaylistDTO toDTO(PlaylistEntity entity) {
		PlaylistDTO dto = new PlaylistDTO();
		dto.setId(entity.getId());
		Set<SongDTO> songs = new HashSet<>();
		for (SongEntity item : entity.getSongs()) {
			SongDTO song = songConverter.toDTO(item);
			songs.add(song);
		}
		dto.setSongs(songs);
		AccountEntity account = accountService.findById(entity.getAccount().getId());
		dto.setUsername(account.getUsername());
		dto.setCreatedDate(entity.getCreatedDate());
		dto.setCreatedBy(entity.getCreatedBy());
		dto.setModifiedBy(entity.getModifiedBy());
		dto.setModifiedDate(entity.getModifiedDate());
		return dto;
	}
}
