package com.theplayer.service;

import com.theplayer.entity.PlaylistEntity;

public interface IPlaylistService extends AbstractService<PlaylistEntity>{
	
	PlaylistEntity findOneByAccountId(Long accountId);
	
	PlaylistEntity findByUserIdAndSongId(Long userId, Long songId);
	
	void delete(PlaylistEntity entity);
	
	void deleteSongInPlaylist(String username, Long songId);
}
