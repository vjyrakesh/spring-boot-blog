package com.rkasibha.blog.configuration;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("posts")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.rkasibha.blog.controllers"))
				.paths(PathSelectors.regex("/api/v1/posts.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	@Bean
	public Docket blogApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("blogs")
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.rkasibha.blog.controllers"))
				.paths(PathSelectors.regex("/api/v1/blog.*"))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Springboot REST API for blog")
				.description("REST API documentation for blog application")
				.license("GPL")
				.version("0.1")
				.contact(new Contact("Rakesh Kasibhatla", "https://www.linkedin.com/in/rakeshkasibhatla/", "rkasibha@cisco.com"))
				.build();
	}
}
