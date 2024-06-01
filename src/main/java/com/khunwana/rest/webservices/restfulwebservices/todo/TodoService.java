package com.khunwana.rest.webservices.restfulwebservices.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.stereotype.Service;
import jakarta.validation.Valid;

@Service
public class TodoService {
	private static ArrayList<Todo> todos= new ArrayList<Todo>();;
	private static int todoCount = 0;

	static {
		todos.add(new Todo(++todoCount,"Khunwana", "master Springboot",LocalDate.now().plusMonths(1),false));
		todos.add(new Todo(++todoCount,"Khunwana", "master SpringSecurity",LocalDate.now().plusMonths(1),false));
		todos.add(new Todo(++todoCount,"Khunwana", "master FullStack dev",LocalDate.now().plusMonths(1),false));
	}
	
	public List<Todo> findByUsername(String username)
	{
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);
		
		return todos.stream().filter(predicate).toList();
	}
	
	public Todo addnewTodo(String username, String description, LocalDate targetDate, boolean done)
	{
		Todo todo = new Todo(++todoCount,username,description,targetDate,done);
		todos.add(todo);
		return todo;
	}
	
	public void deleteById(int id)
	{
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
		
	}
	

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);		
	}
	
	
}
