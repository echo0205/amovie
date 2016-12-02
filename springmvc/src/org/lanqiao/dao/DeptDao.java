package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Dept;

public interface DeptDao {
	public List<Dept> queryDeptAll();

	public Dept findDeptById(int id);

	public void addDept(Dept dept);
}
