package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Posts;

public interface PostsService {
	public List<Posts> queryPosts();
	public List<Posts> queryPostsByid(int id);
}
