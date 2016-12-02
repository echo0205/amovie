package org.lanqiao.dao.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.lanqiao.entity.EmpQueryVo;
import org.lanqiao.entity.Employee;
import org.lanqiao.vo.Paging;

public class EmployeeDaoImpTest {
	private EmployeeDaoImp employeeDaoImp = null;
	@Before
	public void setUp() throws Exception {
		employeeDaoImp = new EmployeeDaoImp();
	}

	@Test
	public void testQueryAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddEmployee() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryOneByid() {
		Employee queryOneByid = employeeDaoImp.queryOneByid(3);
		queryOneByid.getEmail();
	}

	@Test
	public void testDeleteEmpByid() {
	}

	@Test
	public void testUpdateEmpByid() {
		Employee emp = new Employee();
		emp.setId(18);
		emp.setName("der");
		emp.setEmail("sewr");
		emp.setTelphone("we3749");
		emp.setDeptId(3);
		employeeDaoImp.updateEmpByid(emp);
	}
	
	@Test
	public void testQueryBypaging() {
		List<Employee> queryBypaging = employeeDaoImp.queryBypaging(1, 3);
		for (Employee employee : queryBypaging) {
			System.out.println(employee);
		}
	}
}
