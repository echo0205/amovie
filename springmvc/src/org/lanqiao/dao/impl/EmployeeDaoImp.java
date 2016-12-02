package org.lanqiao.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.entity.Employee;
import org.lanqiao.utils.JdbcUtils;
import org.lanqiao.utils.MyBatisUtil;
import org.lanqiao.vo.Paging;


public class EmployeeDaoImp implements EmployeeDao{
	private JdbcUtils jdbcUtils = new JdbcUtils();

	@Override
	public List<Employee> queryAll() {
		List<Employee> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.EmpMapper.selectEmployee", null);
		return list;
	}

	@Override
	public void addEmployee(Employee emp) {
		emp.setRegDate(new Date());
		MyBatisUtil.updateExecute("org.lanqiao.sqlxml.EmpMapper.insertEmployee", emp);
	}
	
	@Override
	public Employee queryOneByid(int id) {
		Employee emp = (Employee) MyBatisUtil.queryOneExecute("org.lanqiao.sqlxml.EmpMapper.selectEmployeeByid", id);
		return emp;
	}

	@Override
	public void deleteEmpByid(int id) {
		MyBatisUtil.deleteExecute("org.lanqiao.sqlxml.EmpMapper.deleteEmployeeById", id);
	}

	@Override
	public void updateEmpByid(Employee emp) {
		MyBatisUtil.updateExecute("org.lanqiao.sqlxml.EmpMapper.updateEmployeeById", emp);
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<Employee> queryBypaging1(int pageNow, int pageSize) {
		Paging paging  = new Paging();
		paging.setOffset((pageNow-1)*pageSize);
		paging.setLimit(pageSize);
		List<Employee> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.EmpMapper.pagingEmployee", paging);
		return list;
	}
	//bootstrap-table分页
	public List<Employee> queryBypaging(int pageNow, int pageSize) {
		Paging paging  = new Paging();
		paging.setOffset(pageNow);
		paging.setLimit(pageSize);
		List<Employee> list = MyBatisUtil.queryExecute("org.lanqiao.sqlxml.EmpMapper.pagingEmployee", paging);
		return list;
	}
}  
