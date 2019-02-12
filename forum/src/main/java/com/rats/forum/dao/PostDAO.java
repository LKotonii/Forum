package com.rats.forum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rats.forum.entity.Comment;
import com.rats.forum.entity.Post;
import com.rats.forum.entity.User;

@Repository
public class PostDAO {

	private EntityManager entityManager;

	@Autowired
	public PostDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public List<Post> findPostsByAuthor(String username) {

		TypedQuery<User> theQuery = entityManager.createQuery("from User u where u.username=" + username, User.class);
		User theUser = theQuery.getSingleResult();
		List<Post> posts = new ArrayList<>();
		if (theUser != null) {
			TypedQuery<Post> postQuery = entityManager.createQuery("from Post p where p.authorId=" + theUser.getId(),
					Post.class);
			posts = postQuery.getResultList();
		}

		return posts;
	}
	
	public List<Comment> getAllCommentsByPostId(int postId){
		
		TypedQuery<Comment> theQuery = entityManager.createQuery("from Comment c where c.postId=" + postId, Comment.class);
		List <Comment> comments = theQuery.getResultList();
		return comments;
	}

	public List<Post> findPostsByTitle(String title) {
		TypedQuery<Post> theQuery = entityManager.createQuery("from Post p where p.title=" + title, Post.class);
		List <Post> posts = theQuery.getResultList();
		return posts;
	}

}
