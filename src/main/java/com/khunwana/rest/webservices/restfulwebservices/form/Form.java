package com.khunwana.rest.webservices.restfulwebservices.form;



import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;


@Entity
public class Form {
	
	public Form()
	{
		
	}

	public Form(Integer id, String name, String email, String subject, String comment, boolean done) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.comment = comment;
		this.done = done;
	}
	
	@Id
	@GeneratedValue
	private Integer id;

	private String name;
	private String subject;
	private String comment;
	
	@Size(min=10, message="Enter atleast 10 characters")
	private String email;
	
	
	private boolean done;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", Name=" + name + ", Email=" + email + ", subject="
				+ subject + ", done=" + done + "]";
	}

}