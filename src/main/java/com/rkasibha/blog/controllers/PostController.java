package com.rkasibha.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rkasibha.blog.models.Post;
import com.rkasibha.blog.repository.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping(value="/api/v1/posts", method=RequestMethod.GET)
	public ResponseEntity<List<Post>> getAllPosts() {
		return new ResponseEntity<List<Post>>(postRepository.findAll(), HttpStatus.OK);
	}
}
