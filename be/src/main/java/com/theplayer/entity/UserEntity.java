package com.theplayer.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	private String fullName;
	@OneToMany(mappedBy = "user")
	private List<VideoEntity> videos = new ArrayList<>();
	
	public List<VideoEntity> getVideos() {
		return videos;
	}

	public void setVideos(List<VideoEntity> videos) {
		this.videos = videos;
	}
	@Email
	private String email;

	private String address;
	
	private String gender;
	
	@Max(value = 10)
	private String phone;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;

	@OneToMany(mappedBy = "user")
	private List<CommentEntity> comments = new ArrayList<>();


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "account_id", referencedColumnName = "id")
	private AccountEntity account;
	
	@OneToMany(mappedBy = "user")
	private List<RatingEntity> ratings = new ArrayList<>();

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}
	
}
