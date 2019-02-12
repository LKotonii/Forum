package com.rats.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rats.forum.dao.PostDAO;
import com.rats.forum.dao.PostRepository;
import com.rats.forum.entity.Comment;
import com.rats.forum.entity.Post;

@Service
public class PostService {

	private PostRepository postRepository;
	
	private PostDAO postDAO;
	
	@Autowired
	public PostService(PostRepository thePostRepository, PostDAO thePostDAO) {
		postDAO = thePostDAO;
		postRepository = thePostRepository;
	}

	@Transactional
	public List<Comment> getAllCommentsByPostId(int postId){
		return postDAO.getAllCommentsByPostId(postId);
	}
	
	@Transactional
	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}
	
	@Transactional
	public List<Post> getPostsByTitle(String title){
		return postDAO.findPostsByTitle(title);
	}
	
	@Transactional 
	public List<Post> getPostByAuthor(String username) {
		return postDAO.findPostsByAuthor(username);
	}

	@Transactional	
	public void savePost(Post thePost) {
		postRepository.save(thePost);
	}
	
	@Transactional	
	public Post getPostById (int postId) {
		return postRepository.getOne(postId);
	}
}
