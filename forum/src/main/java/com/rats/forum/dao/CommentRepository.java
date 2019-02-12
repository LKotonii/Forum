package com.rats.forum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rats.forum.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
