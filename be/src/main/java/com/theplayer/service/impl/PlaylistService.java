package com.theplayer.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.theplayer.entity.AccountEntity;
import com.theplayer.entity.PlaylistEntity;
import com.theplayer.entity.SongEntity;
import com.theplayer.repository.PlaylistRepository;
import com.theplayer.service.IPlaylistService;

@Service
public class PlaylistService implements IPlaylistService {

	@Autowired
	private PlaylistRepository playlistRepository;

	@Autowired
	private AccountService accountService;

	@Autowired
	private SongService songService;

	@Override
	public PlaylistEntity save(PlaylistEntity entity) {
		return playlistRepository.save(entity);
	}

	@Override
	public List<PlaylistEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int totalItem() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PlaylistEntity> findAll() {
		return playlistRepository.findAll();
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			playlistRepository.deleteById(id);
		}
	}

	@Override
	public void delete(PlaylistEntity entity) {
		playlistRepository.delete(entity);
	}

	@Override
	public PlaylistEntity findOneByAccountId(Long accountId) {
		// TODO Auto-generated method stub
		return playlistRepository.findOneByAccountId(accountId);
	}

	@Override
	public PlaylistEntity findByUserIdAndSongId(Long userId, Long songId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteSongInPlaylist(String username, Long songId) {
		AccountEntity account = accountService.findOneByUsername(username);
		SongEntity song = songService.findOneById(songId);
		PlaylistEntity playlist = playlistRepository.findOneByAccountId(account.getId());
		if (account != null && song != null && playlist != null && playlist.getSongs().contains(song)) {
			playlist.getSongs().remove(song);
		}
		playlistRepository.save(playlist);
	}

}
