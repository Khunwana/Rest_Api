package com.khunwana.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.khunwana.rest.webservices.restfulwebservices.todo.repository.TodoRepository;

@RestController
public class TodoJpaResource {

	private TodoService to_doService;
	private TodoRepository to_doRepo;
	
	public TodoJpaResource(TodoService to_doService,TodoRepository to_doRepo)
	{
		this.to_doService = to_doService;
		this.to_doRepo = to_doRepo;
	}
	
	@GetMapping(path="/basicAuth")
	public String basicAuth()
	{
		return "Success";
	}

//	@GetMapping(path="/")
//	public String homeRouting()
//	{
//		return "home";
//	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTo_Do(@PathVariable String username)
	{
//		return to_doService.findByUsername(username);
		return to_doRepo.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTo_Do(@PathVariable String username ,@PathVariable int id)
	{
//		return to_doService.findById(id);
		return to_doRepo.findById(id).get();
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTo_DO(@PathVariable String username ,@PathVariable int id)
	{
//		to_doService.deleteById(id);
		to_doRepo.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTo_DO(@PathVariable String username ,@PathVariable int id,@RequestBody Todo todo) {
//		to_doService.updateTodo(todo);
		to_doRepo.save(todo);
		return todo;
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo createTo_Do(@PathVariable String username,@RequestBody Todo todo) {
		
		todo.setUsername(username);
		todo.setId(null);
		return to_doRepo.save(todo);
		
//		Todo created_ToDo = to_doService.addnewTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
//		return created_ToDo;
	}
}
