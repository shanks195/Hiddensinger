package com.theplayer.dto;

public class CommentDTO extends AbstractDTO<CommentDTO>{
	
	private Long songId;
	
	private String username;
	
	private String content;
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
