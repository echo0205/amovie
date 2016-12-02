package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.Dept;


public interface DeptService {
	public void addList(Dept dept);
	public List<Dept> queryDeptAll();
}
