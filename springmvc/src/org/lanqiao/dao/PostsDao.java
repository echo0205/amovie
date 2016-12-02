package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Posts;

public interface PostsDao {
	public List<Posts> queryAll();
	public List<Posts> queryAllByid(int id);
}
