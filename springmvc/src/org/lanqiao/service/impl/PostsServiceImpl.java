package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.PostsDao;
import org.lanqiao.dao.impl.PostsDaoImpl;
import org.lanqiao.entity.Posts;
import org.lanqiao.service.PostsService;

public class PostsServiceImpl implements PostsService{
	private PostsDao postsDao = new PostsDaoImpl();
	@Override
	public List<Posts> queryPosts() {
		List<Posts> list = postsDao.queryAll(); 
		return list;
	}
	@Override
	public List<Posts> queryPostsByid(int id) {
		List<Posts> list = postsDao.queryAllByid(id);
		return list;
	}
	
}
