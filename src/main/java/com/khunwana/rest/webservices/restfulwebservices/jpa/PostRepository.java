package com.khunwana.rest.webservices.restfulwebservices.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khunwana.rest.webservices.restfulwebservices.posts.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
