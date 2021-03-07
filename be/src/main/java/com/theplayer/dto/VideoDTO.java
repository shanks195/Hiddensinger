package com.theplayer.dto;



public class VideoDTO extends AbstractDTO<VideoDTO>  {
	private String fullname;
	private String username;
	private String name;	
	private String url;
	
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setId(long id) {
		// TODO Auto-generated method stub
		
	}
	
}
