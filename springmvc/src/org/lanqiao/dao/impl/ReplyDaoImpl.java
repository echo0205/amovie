package org.lanqiao.dao.impl;

import java.util.List;

import org.lanqiao.dao.ReplyDao;
import org.lanqiao.entity.Reply;
import org.lanqiao.utils.MyBatisUtil;

public class ReplyDaoImpl implements ReplyDao {

	@Override
	public List<Reply> selectReplyByPostsid(int id) {
		List<Reply> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.ReplyMapper.selectReplyByid", id);
		return list;
	}

}
