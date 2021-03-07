package com.theplayer.dto;

import java.util.HashSet;
import java.util.Set;

public class PlaylistDTO extends AbstractDTO<PlaylistDTO>{
	
	private String username;
	
	private Long songId;
	
	private Set<SongDTO> songs = new HashSet<>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getSongId() {
		return songId;
	}
	public void setSongId(Long songId) {
		this.songId = songId;
	}
	public Set<SongDTO> getSongs() {
		return songs;
	}
	public void setSongs(Set<SongDTO> songs) {
		this.songs = songs;
	}
}
