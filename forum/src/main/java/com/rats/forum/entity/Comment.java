package com.rats.forum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forum_comment")
public class Comment {

	

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "author_id")
	private int authorId;

	@Id
	@Column(name = "post_id")
	private int postId;

	@Column(name = "content")
	private String content;

	public Comment() {
	}

	public Comment(int authorId, int postId, String content) {
		this.authorId = authorId;
		this.content = content;
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Comment [authorId=" + authorId + ", postId=" + postId + ", content=" + content + "]";
	}

}
