package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comment;

public interface CommentRepo extends JpaRepository<Comment, Long>{

}