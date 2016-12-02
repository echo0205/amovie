package org.lanqiao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.lanqiao.dao.DeptDao;
import org.lanqiao.dao.EmployeeDao;
import org.lanqiao.dao.impl.DeptDaoImpl;
import org.lanqiao.dao.impl.EmployeeDaoImp;
import org.lanqiao.entity.Dept;
import org.lanqiao.entity.EmpQueryVo;
import org.lanqiao.entity.Employee;
import org.lanqiao.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImp();
	private DeptDao Deptdao = new DeptDaoImpl();
	@Override
	public List<EmpQueryVo> queryList() {
		List<EmpQueryVo> EmpQueryVolists= new ArrayList<EmpQueryVo>();
		List<Employee> list = dao.queryAll();//private Employee emp;
		for (Employee employee : list) {
			EmpQueryVo empQueryVo = new EmpQueryVo();
			Integer deptId = employee.getDeptId();
			Dept dept = Deptdao.findDeptById(deptId);
			empQueryVo.setEmp(employee);
			empQueryVo.setDeptName(dept.getDeptname());//private String deptName;
			EmpQueryVolists.add(empQueryVo);
		}
		return EmpQueryVolists;
	}
	@Override
	public void addList(Employee emp) {
		dao.addEmployee(emp);
	}
	@Override
	public void deleteEmpByid(int id) {
		dao.deleteEmpByid(id);
	}
	@Override
	public void updateEmpByid(Employee emp) {
		dao.updateEmpByid(emp);
	}
	@Override
	public Employee queryOneEmp(int id) {
		Employee emp = dao.queryOneByid(id);
		return emp;
	}
	/**
	 * 分页查询
	 */
	@Override
	public List<EmpQueryVo> queryBypaging1(int pageNow, int pageSize) {
		List<EmpQueryVo> empQueryVos = new ArrayList<EmpQueryVo>();
		List<Employee> employees = dao.queryBypaging1(pageNow, pageSize);
		for (Employee employee : employees) {
			EmpQueryVo empQueryVo = new EmpQueryVo();
			Integer deptId = employee.getDeptId();
			Dept dept = Deptdao.findDeptById(deptId);
			empQueryVo.setEmp(employee);
			empQueryVo.setDeptName(dept.getDeptname());
			empQueryVos.add(empQueryVo);
		}
		return empQueryVos;
	}
	@Override
	public List<EmpQueryVo> queryBypaging(int pageNow, int pageSize) {
		List<EmpQueryVo> empQueryVos = new ArrayList<EmpQueryVo>();
		List<Employee> employees = dao.queryBypaging(pageNow, pageSize);
		for (Employee employee : employees) {
			EmpQueryVo empQueryVo = new EmpQueryVo();
			Integer deptId = employee.getDeptId();
			Dept dept = Deptdao.findDeptById(deptId);
			empQueryVo.setEmp(employee);
			empQueryVo.setDeptName(dept.getDeptname());
			empQueryVos.add(empQueryVo);
		}
		return empQueryVos;
	}

}
