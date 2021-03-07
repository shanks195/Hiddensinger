package com.theplayer.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "playlist")
public class PlaylistEntity extends BaseEntity{
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountEntity account;
	
	@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinTable(	name = "playlist_song", 
		joinColumns = @JoinColumn(name = "playlist_id"), 
		inverseJoinColumns = @JoinColumn(name = "song_id"))
	private Set<SongEntity> songs = new HashSet<>();

	public Set<SongEntity> getSongs() {
		return songs;
	}

	public void setSongs(Set<SongEntity> songs) {
		this.songs = songs;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
}
