package com.khunwana.rest.webservices.restfulwebservices.user;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

//@Entity(name="user_details")
public class User {
	
	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}
	
//	@Id
//	@GeneratedValue
	private int id;
	
	@Size(min=2, message = "Name should have atleast 2 characters") //annotation from validation to check if a minimum of 2 character has been entered
	private String name;
	
	@Past(message = "Birth date should always be in the past") //annotation to check if the date entered is in the past of current date
	private LocalDate birthDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
	
	
	
}
