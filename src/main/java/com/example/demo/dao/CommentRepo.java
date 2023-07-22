package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comment;

/**
 * CommentRepo is a Data Access Object (DAO) that extends the JpaRepository interface.
 * It provides pre-defined methods for interacting with the underlying database to perform CRUD operations on comment entities.
 */
public interface CommentRepo extends JpaRepository<Comment, Long>{

}
