package com.rkasibha.blog.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rkasibha.blog.models.Comment;
import com.rkasibha.blog.models.Post;
import com.rkasibha.blog.models.ServiceHealth;
import com.rkasibha.blog.repository.PostRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Posts operations", description="API operations on Posts")
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@RequestMapping(value="/api/v1/ping", method=RequestMethod.GET)
	public ResponseEntity<ServiceHealth> ping() {
		ServiceHealth health = new ServiceHealth();
		health.setName("blog");
		health.setStatus("online");
		return new ResponseEntity<ServiceHealth>(health, HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/posts", method=RequestMethod.GET)
	@ApiOperation(value="Get all posts")
	public ResponseEntity<List<Post>> getAllPosts() {
		return new ResponseEntity<List<Post>>(postRepository.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/api/v1/posts", method=RequestMethod.POST)
	@ApiOperation(value="Add a new post")
	public ResponseEntity<Post> addPost(@RequestBody Post post) {
		return new ResponseEntity<Post>(postRepository.save(post), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="api/v1/posts/{id}", method=RequestMethod.GET)
	@ApiOperation(value="Get a post by id")
	public ResponseEntity<Post> findPostById(@PathVariable("id") Integer id) {
		Optional<Post> post = postRepository.findById(id);
		if(post.isPresent()) {
			return new ResponseEntity<Post>(post.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<Post>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="api/v1/posts/{id}/comments", method=RequestMethod.GET)
	@ApiOperation(value="Get all comments for a post")
	public ResponseEntity<List<Comment>> getCommentsForPostById(@PathVariable("id") Integer id) {
		Optional<Post> post = postRepository.findById(id);
		if(post.isPresent()) {
			return new ResponseEntity<List<Comment>>(post.get().getComments(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Comment>>(HttpStatus.NOT_FOUND);
		}
	}
}
