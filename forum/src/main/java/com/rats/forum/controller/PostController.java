package com.rats.forum.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rats.forum.entity.Comment;
import com.rats.forum.entity.Post;
import com.rats.forum.service.PostService;

@Controller
public class PostController {

	@Autowired 
	PostService postService;
	
	@RequestMapping("/all-posts")
	public String allPostsWithComments(Model theModel) {
	List<Post> allPosts = postService.getAllPosts()	;
	List<Comment> commentsForPost;
	Map<Post, List<Comment>> postsWithComments = new HashMap<>();
	for (Post p: allPosts) {
		commentsForPost = new ArrayList<Comment>();
		commentsForPost = postService.getAllCommentsByPostId(p.getId());
		postsWithComments.put(p, commentsForPost);
	}
	theModel.addAttribute("allPosts", postsWithComments);
	return "all-posts";	
	}
	
	
	@RequestMapping("/new-post")
	public String createNewPost() {
		return "post-form";
	}

}
