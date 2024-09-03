package com.khunwana.rest.webservices.restfulwebservices.homepage.education;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Education {
	
	@Id
	private long id;
	private String due_year;
	private String course_stream;
	private String institution;
	private String place_institution;
	private String description;
	
	public Education()
	{
		
	}
	public Education(long id, String due_year, String course_stream, String institution, String place_institution,
			String description) {
		super();
		this.id = id;
		this.due_year = due_year;
		this.course_stream = course_stream;
		this.institution = institution;
		this.place_institution = place_institution;
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDue_year() {
		return due_year;
	}
	public void setDue_year(String due_year) {
		this.due_year = due_year;
	}
	public String getCourse_stream() {
		return course_stream;
	}
	public void setCourse_stream(String course_stream) {
		this.course_stream = course_stream;
	}
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getPlace_institution() {
		return place_institution;
	}
	public void setPlace_institution(String place_institution) {
		this.place_institution = place_institution;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Education [id=" + id + ", due_year=" + due_year + ", course_stream=" + course_stream + ", institution="
				+ institution + ", place_institution=" + place_institution + ", description=" + description + "]";
	}
	
	
	

}