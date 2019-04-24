package com.rkasibha.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkasibha.blog.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
