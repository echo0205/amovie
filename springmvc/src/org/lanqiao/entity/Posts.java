package org.lanqiao.entity;

import java.util.Date;
import java.util.List;

public class Posts {
	private int id;
	private String author;
	private String title;
	private Date postsDate;
	private String postsContent;
	private List<Reply> reply;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getPostsDate() {
		return postsDate;
	}
	public void setPostsDate(Date postsDate) {
		this.postsDate = postsDate;
	}
	
	public String getPostsContent() {
		return postsContent;
	}
	public void setPostsContent(String postsContent) {
		this.postsContent = postsContent;
	}
	public List<Reply> getReply() {
		return reply;
	}
	public void setReply(List<Reply> reply) {
		this.reply = reply;
	}

	
}
