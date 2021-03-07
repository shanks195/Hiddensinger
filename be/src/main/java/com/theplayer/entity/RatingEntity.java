package com.theplayer.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rating")
public class RatingEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "song_id")
	private SongEntity song;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	private String subRating;


	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public SongEntity getSong() {
		return song;
	}

	public void setSong(SongEntity song) {
		this.song = song;
	}

	public String getSubRating() {
		return subRating;
	}

	public void setSubRating(String subRating) {
		this.subRating = subRating;
	}
}
