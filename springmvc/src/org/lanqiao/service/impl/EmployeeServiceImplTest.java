package org.lanqiao.service.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.lanqiao.entity.EmpQueryVo;
import org.lanqiao.service.EmployeeService;

public class EmployeeServiceImplTest {
	private EmployeeService employeeService = null;
	@Before
	public void setUp() throws Exception {
		employeeService = new EmployeeServiceImpl();
	}

	@Test
	public void test() {
		List<EmpQueryVo> queryBypaging = employeeService.queryBypaging(1, 5);
		for (EmpQueryVo empQueryVo : queryBypaging) {
			System.out.println(empQueryVo.toString());
		}
	}

}
