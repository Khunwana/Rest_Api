package com.khunwana.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.khunwana.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.khunwana.rest.webservices.restfulwebservices.jpa.UserRepository;
import com.khunwana.rest.webservices.restfulwebservices.posts.Post;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {
	
	private UserRepository repo;
	private PostRepository postRepository;
	
	public UserJpaResource(PostRepository postRepository,UserRepository repo)
	{
		this.repo = repo;
		this.postRepository = postRepository;
	}

	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers()
	{
		return repo.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id)
	{
		Optional<User> user = repo.findById(id);
		
		if(user.isEmpty())
		{
			throw new UserNotFoundException("Id :"+id);
		}
		
		EntityModel<User> entityModel = EntityModel.of(user.get());
		
		WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(linkBuilder.withRel("all-users"));
		return entityModel;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		User savedUser = repo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id)
	{
		repo.deleteById(id);
	
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> getAllPosts(@PathVariable int id)
	{
		Optional<User> user = repo.findById(id);
		
		if(user.isEmpty())
		{
			throw new UserNotFoundException("Id :"+id);
		}
		
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> CreateAPost(@PathVariable int id,@Valid @RequestBody Post post)
	{
		Optional<User> user = repo.findById(id);
		
		if(user.isEmpty())
		{
			throw new UserNotFoundException("Id :"+id);
		}
		
		post.setUser(user.get());
		
		Post savedPost = postRepository.save(post);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(savedPost.getId())
		.toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/jpa/users/{id}/posts/{p_id}")
	public Optional<Post> getPost(@PathVariable int id,@PathVariable int p_id,@Valid @RequestBody Post post)
	{
		Optional<User> user = repo.findById(id);
		
		if(user.isEmpty())
		{
			throw new UserNotFoundException("Id :"+id);
		}
		
		post.setUser(user.get());
		
		return postRepository.findById(p_id);
	}
}
