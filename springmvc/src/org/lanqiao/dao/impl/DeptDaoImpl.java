package org.lanqiao.dao.impl;

import java.util.List;

import org.lanqiao.dao.DeptDao;
import org.lanqiao.entity.Dept;
import org.lanqiao.utils.JdbcUtils;
import org.lanqiao.utils.MyBatisUtil;

public class DeptDaoImpl implements DeptDao {
	@Override
	public List<Dept> queryDeptAll() {
		List<Dept> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.DeptMapper.selectDept", null);
		return list;
	}
	@Override
	public Dept findDeptById(int id) {
		Dept dept  = (Dept) MyBatisUtil.queryOneExecute("org.lanqiao.sqlxml.DeptMapper.selectDeptByid", id);
		return dept;
	}
	@Override
	public void addDept(Dept dept) {
		MyBatisUtil.insertExecute("org.lanqiao.sqlxml.DeptMapper.insertDept", dept);
	}

}
