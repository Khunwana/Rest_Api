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

@RestController
public class TodoResource {
	
	private TodoService to_doService;
	
	public TodoResource(TodoService to_doService)
	{
		this.to_doService = to_doService;
	}
	
	@GetMapping(path="/basicAuth")
	public String basicAuth()
	{
		return "Success";
	}
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTo_Do(@PathVariable String username)
	{
		return to_doService.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTo_Do(@PathVariable String username ,@PathVariable int id)
	{
		return to_doService.findById(id);
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTo_DO(@PathVariable String username ,@PathVariable int id)
	{
		to_doService.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTo_DO(@PathVariable String username ,@PathVariable int id,@RequestBody Todo todo) {
		to_doService.updateTodo(todo);
		return todo;
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo createTo_Do(@PathVariable String username,@RequestBody Todo todo) {
		Todo created_ToDo = to_doService.addnewTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return created_ToDo;
	}
}
