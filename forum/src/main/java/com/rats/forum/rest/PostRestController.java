package com.rats.forum.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rats.forum.entity.Comment;
import com.rats.forum.entity.Post;
import com.rats.forum.service.CommentService;
import com.rats.forum.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostRestController {

	
	private PostService postService;
	private CommentService commentService;
	
	@Autowired
	public PostRestController (PostService thePostService , CommentService theCommentService) {
		postService = thePostService;
		commentService = theCommentService;
		
	}
	
	@GetMapping("/all")
	public List<Post> getAllPosts(){
		return postService.getAllPosts();
	}
	
	@GetMapping("/get-post/{postId}")
	public Post getPost (@PathVariable int postId) {
		 Post thePost = postService.getPostById(postId);
		 if( thePost == null) {
			 throw new RuntimeException("post id not found - " + postId);
		 }
		 return thePost;
	}
	
	@GetMapping("/get-post&comments/{postId}")
	public Map<Post, Object> getPostWithComments(@PathVariable int postId){
		HashMap<Post, Object> postWithComments = new HashMap<>();
		Post thePost = postService.getPostById(postId);
		List<Comment> comments = commentService.getAll_commentsForPost(postId);
		postWithComments.put(thePost, comments);
		return postWithComments;
	}
	
	@PostMapping("/new-post")
	public Post addNewPost(@RequestBody Post thePost) {
		// force a save of new post instead of update
		thePost.setId(0);
		postService.savePost(thePost);
		return thePost;
	}

	
	
	
}
