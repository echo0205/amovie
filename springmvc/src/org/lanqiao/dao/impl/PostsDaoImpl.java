package org.lanqiao.dao.impl;

import java.util.List;

import org.lanqiao.dao.PostsDao;
import org.lanqiao.entity.Posts;
import org.lanqiao.utils.MyBatisUtil;

public class PostsDaoImpl implements PostsDao{

	@Override
	public List<Posts> queryAll() {
		List<Posts> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.PostsMapper.selectPosts", null);
		return list;
	}

	@Override
	public List<Posts> queryAllByid(int id) {
		List<Posts> list = MyBatisUtil.queryExecute("org.lanqiao.mapper.PostsMapper.selectPostsByid", id);
		return list;
	}

}
