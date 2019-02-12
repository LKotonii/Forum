package com.rats.forum.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "forum_post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "author_id")
	private int authorId;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	//@Column(name="last_update")
	//private Date lastUpdate;
	
	public Post() {
	}

	public Post(int authorId, String content) {
		this.authorId = authorId;
		this.content = content;
	}

	public Post(int authorId, String title, String content) {

		//this.lastUpdate = new Date();
		this.authorId = authorId;
		this.title = title;
		this.content = content;

	}

	@Override
	public String toString() {

		return "Post [id=" + id + ", authorId=" + authorId + ", title=" + title + ", content=" + content + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String post) {
		this.content = post;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

}
