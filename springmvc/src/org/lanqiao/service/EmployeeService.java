package org.lanqiao.service;

import java.util.List;

import org.lanqiao.entity.EmpQueryVo;
import org.lanqiao.entity.Employee;
public interface EmployeeService {

	public List<EmpQueryVo> queryList();
	public void addList(Employee emp);
	public void deleteEmpByid(int id);
	public Employee queryOneEmp(int id);
	public void updateEmpByid(Employee emp);
	public List<EmpQueryVo> queryBypaging1(int pageNow,int pageSize);
	public List<EmpQueryVo> queryBypaging(int pageNow,int pageSize);
}
