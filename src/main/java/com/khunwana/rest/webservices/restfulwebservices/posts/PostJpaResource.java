package com.khunwana.rest.webservices.restfulwebservices.posts;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.khunwana.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.khunwana.rest.webservices.restfulwebservices.user.User;

public class PostJpaResource {
	
	private PostRepository postRepository;
	
	public PostJpaResource(PostRepository postRepository)
	{
		this.postRepository = postRepository;
	}
	
	

}
