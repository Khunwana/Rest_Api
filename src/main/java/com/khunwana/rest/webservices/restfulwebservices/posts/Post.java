package com.khunwana.rest.webservices.restfulwebservices.posts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khunwana.rest.webservices.restfulwebservices.user.User;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Post {
	
	public Post()
	{
		
	}
	
	public Post(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}
	
	@Id
	@GeneratedValue
	private int id;
	private String description;
	
	@ManyToOne(fetch =  FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", decription=" + description + "]";
	}
	
	

}
