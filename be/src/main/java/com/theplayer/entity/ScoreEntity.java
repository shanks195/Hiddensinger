package com.theplayer.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class ScoreEntity extends BaseEntity{
	
	private int month;
	
	private int year;
	
	private Float score;
	
	@ManyToOne
	@JoinColumn(name = "song_id")
	private SongEntity song;

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public SongEntity getSong() {
		return song;
	}

	public void setSong(SongEntity song) {
		this.song = song;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}
}
