package com.rkasibha.blog;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.rkasibha.blog.models.ServiceHealth;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public class PostControllerTests {

	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void testGetAllPosts() {
		
	}
	
	@Test
	public void testPing() {
		ResponseEntity<ServiceHealth> responseEntity = restTemplate.getForEntity("/api/v1/ping", ServiceHealth.class);
		assertEquals(200, responseEntity.getStatusCode().value());
		assertEquals("blog", responseEntity.getBody().getName());
		assertEquals("online", responseEntity.getBody().getStatus());
		
		responseEntity = restTemplate.getForEntity("/api/v1/ping1", ServiceHealth.class);
		assertEquals(404, responseEntity.getStatusCode().value());
	}
}
