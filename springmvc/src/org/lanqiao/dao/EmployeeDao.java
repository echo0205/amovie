package org.lanqiao.dao;

import java.util.List;

import org.lanqiao.entity.Employee;
import org.lanqiao.vo.Paging;

public interface EmployeeDao {
	public List<Employee> queryAll();
	public Employee queryOneByid(int id);
	public void addEmployee(Employee emp);
	public void deleteEmpByid(int id);
	public void updateEmpByid(Employee emp);
	//分页
	public List<Employee> queryBypaging1(int pageNow, int pageSize);
	public List<Employee> queryBypaging(int pageNow, int pageSize);
}
