package org.lanqiao.service.impl;

import java.util.List;

import org.lanqiao.dao.DeptDao;
import org.lanqiao.dao.impl.DeptDaoImpl;
import org.lanqiao.entity.Dept;
import org.lanqiao.service.DeptService;

public class deptServiceImpl implements DeptService {
	private DeptDao deptDao = new DeptDaoImpl();
	@Override
	public void addList(Dept dept) {
		deptDao.addDept(dept);
	}
	@Override
	public List<Dept> queryDeptAll() {
		List<Dept> deptList = null;
		deptList = deptDao.queryDeptAll();
		return deptList;
	}

}
