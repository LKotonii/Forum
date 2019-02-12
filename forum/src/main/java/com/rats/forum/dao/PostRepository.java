package com.rats.forum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rats.forum.entity.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
