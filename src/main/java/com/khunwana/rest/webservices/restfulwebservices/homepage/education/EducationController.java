package com.khunwana.rest.webservices.restfulwebservices.homepage.education;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@Controller
public class EducationController {
	
	private EducationService educationService;
	
	public EducationController(EducationService educationService )
	{
		super();
		this.educationService = educationService;
		
	}	
	
	//adding mapping to education jsp
	@RequestMapping("education")
	public String showeducation(ModelMap modelMap)
	{
		List<Education> educations = educationService.findByUsername("Khunwana");
		modelMap.addAttribute("educations",educations);
		return "education";
	}
	
	//mapping to creating new education 
	@RequestMapping(value="add-education",method = RequestMethod.GET)
	public String showEducation(ModelMap modelMap)
	{
		Education educations = new Education(0,"","","","","");
		modelMap.put("educations", educations);
		return "addEducation";
	}
	
	//mapping to adding new education
	@RequestMapping(value="add-education",method = RequestMethod.POST)
	//	@ResponseBody String due_year,String course_stream,String institution,String place_institution,String description
	public String addEducation(@RequestParam String due_year, @Valid Education education,BindingResult bindingResult)
	{
		
		//returning to same page if errors are available
		if(bindingResult.hasErrors())
		{
			return "addEducation";
		}
		educationService.addEducation(due_year, education.getCourse_stream(), education.getInstitution(), education.getPlace_institution(), education.getDescription());
		return "redirect:education"; //redirecting to showing all educations
	}
	

	
	//mapping to deleting new education
	@RequestMapping(value="delete-education",method = RequestMethod.POST)
	//	@ResponseBody String due_year,String course_stream,String institution,String place_institution,String description
	public String deleteEducation(ModelMap modelMap,Education education)
	{
		educationService.deleteEducation(education.getDue_year(), education.getCourse_stream(), education.getInstitution(), education.getPlace_institution(), education.getDescription());
		return "redirect:education"; //redirecting to showing all educations
	}
	
}
