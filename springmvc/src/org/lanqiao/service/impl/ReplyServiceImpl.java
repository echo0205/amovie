package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.ReplyDao;
import org.lanqiao.dao.impl.ReplyDaoImpl;
import org.lanqiao.entity.Reply;
import org.lanqiao.service.ReplyService;

public class ReplyServiceImpl implements ReplyService{
	private ReplyDao replyDao = new ReplyDaoImpl();
	@Override
	public List<Reply> queryReplyByid(int id) {
		List<Reply> list = replyDao.selectReplyByPostsid(id);
		return list;
	}
	
}
