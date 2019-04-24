package com.rkasibha.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkasibha.blog.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
