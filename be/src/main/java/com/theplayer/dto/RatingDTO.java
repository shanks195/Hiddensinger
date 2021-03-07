package com.theplayer.dto;

public class RatingDTO extends AbstractDTO<RatingDTO>{
	
	private Long songId;
	
	private String username;
	
	private String subRating;

	public Long getSongId() {
		return songId;
	}

	public void setSongId(Long songId) {
		this.songId = songId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSubRating() {
		return subRating;
	}

	public void setSubRating(String subRating) {
		this.subRating = subRating;
	}
}
