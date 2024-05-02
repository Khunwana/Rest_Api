package com.khunwana.rest.webservices.restfulwebservices.posts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Post {
	
	public Post(int id, String decription) {
		super();
		this.id = id;
		this.decription = decription;
	}
	
	@Id
	@GeneratedValue
	private int id;
	private String decription;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	@Override
	public String toString() {
		return "Post [id=" + id + ", decription=" + decription + "]";
	}
	
	

}
