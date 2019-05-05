package com.rkasibha.blog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/api/v1/blog")
public class BlogController {
	
	private static final Logger logger = LoggerFactory.getLogger(BlogController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<String> home() {
		logger.info("Serving /api/v1/home");
		return new ResponseEntity<String>("Hello world", HttpStatus.OK);
	}

}
