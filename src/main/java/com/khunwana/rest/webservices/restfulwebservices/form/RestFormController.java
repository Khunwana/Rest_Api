package com.khunwana.rest.webservices.restfulwebservices.form;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khunwana.rest.webservices.restfulwebservices.todo.TodoService;
import com.khunwana.rest.webservices.restfulwebservices.todo.repository.TodoRepository;

@RestController
public class RestFormController {
	
	private TodoService to_doService;
	private TodoRepository to_doRepo;
	
	@RequestMapping("form")
	public String form()
	{
		return "form";
	}

}
