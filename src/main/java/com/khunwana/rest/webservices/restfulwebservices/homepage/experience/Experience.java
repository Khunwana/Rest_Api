package com.khunwana.rest.webservices.restfulwebservices.homepage.experience;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Experience {
	
	@Id
	private long id;
	private String duration_worked;
	private String place_of_work;
	private String company_name;
	private String experience_description;
	
	public Experience()
	{
		
	}

	public Experience(long id, String duration_worked, String place_of_work, String company_name,
			String experience_description) {
		super();
		this.id = id;
		this.duration_worked = duration_worked;
		this.place_of_work = place_of_work;
		this.company_name = company_name;
		this.experience_description = experience_description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDuration_worked() {
		return duration_worked;
	}

	public void setDuration_worked(String duration_worked) {
		this.duration_worked = duration_worked;
	}

	public String getPlace_of_work() {
		return place_of_work;
	}

	public void setPlace_of_work(String place_of_work) {
		this.place_of_work = place_of_work;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getExperience_description() {
		return experience_description;
	}

	public void setExperience_description(String experience_description) {
		this.experience_description = experience_description;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", duration_worked=" + duration_worked + ", place_of_work=" + place_of_work
				+ ", company_name=" + company_name + ", experience_description=" + experience_description + "]";
	}
	
	

}
