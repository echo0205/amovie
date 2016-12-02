package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Reply;

public interface ReplyDao {
	public List<Reply> selectReplyByPostsid(int id);
}
