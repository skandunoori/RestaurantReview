package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comments;

public interface CommentsRepo extends JpaRepository<Comments, Integer>{

}