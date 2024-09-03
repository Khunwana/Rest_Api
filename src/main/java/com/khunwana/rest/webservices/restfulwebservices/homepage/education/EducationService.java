package com.khunwana.rest.webservices.restfulwebservices.homepage.education;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EducationService {
	
	private static List<Education> education = new ArrayList<Education>();
	
	private static int eduCount = 0;
	
	static {
		education.add(new Education(++eduCount, "2009 - 2013", "Matric Certificate in Science", "Mandisa Shiceka High School", "Krugersdorp, RSA",
				"Matriculated High School"));
		education.add(new Education(++eduCount, "2015 - 2020", "Computer System Engineering", "Tshwane University Of Technology", "Pretoria, RSA",
				"Gained skills in both Hardware and Software based technologies from Assembly, C, PLC(Ladder logic)"
				+ " to C++, Php, JavaScript including tools from Raspberry Pi,Arduino to web development."));
	}
	
	//
	public List<Education> findByUsername(String username)
	{
		return education;
	}

	//adding new education metod
	public void addEducation(String due_year,String course_stream,String institution,String place_institution,String description)
	{
		Education educations = new Education(++eduCount,due_year,course_stream,institution,place_institution, description);
		education.add(educations);
	}
	//deleting new education metod
	public void deleteEducation(String due_year,String course_stream,String institution,String place_institution,String description)
	{
		Education educations = new Education(++eduCount,due_year,course_stream,institution,place_institution, description);
		education.add(educations);
	}
}
