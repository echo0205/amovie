package org.lanqiao.entity;

import java.util.Date;

public class Reply {
	private int id;
	private String committer;
	private Date replyDate;
	private String replyContent;
	private int postsId;
	private Posts posts;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCommitter() {
		return committer;
	}
	public void setCommitter(String committer) {
		this.committer = committer;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public int getPostsId() {
		return postsId;
	}
	public void setPostsId(int postsId) {
		this.postsId = postsId;
	}
	public Posts getPosts() {
		return posts;
	}
	public void setPosts(Posts posts) {
		this.posts = posts;
	}
	@Override
	public String toString() {
		return "Reply [id=" + id + ", committer=" + committer + ", replyDate="
				+ replyDate + ", replyContent=" + replyContent + ", postsId="
				+ postsId + ", posts=" + posts + "]";
	}
	
	
}
