package com.rats.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rats.forum.dao.CommentRepository;
import com.rats.forum.entity.Comment;

@Service
public class CommentService {

	private CommentRepository commentRepository;
	
	@Autowired
	public CommentService (CommentRepository thecommentRepository) {
		commentRepository = thecommentRepository;
	}
	
	//TODO  write custom method in commentDAO
	@Transactional
	public List<Comment> getAll_commentsForPost(int postId){
		return ((CommentService) commentRepository).getAll_commentsForPost(postId);
	}
	@Transactional
	public void deleteCommentById(int comId) {
		commentRepository.deleteById(comId);
	}
	@Transactional
	public void saveComment (Comment theComment) {
		commentRepository.save(theComment);
	}
}
