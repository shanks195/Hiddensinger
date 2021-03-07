package com.theplayer.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "log")
public class LogEntity extends BaseEntity {
	
	private String ip;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private AccountEntity account;
	
	@ManyToOne
	@JoinColumn(name = "song_id")
	private SongEntity song;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public SongEntity getSong() {
		return song;
	}

	public void setSong(SongEntity song) {
		this.song = song;
	}
}
