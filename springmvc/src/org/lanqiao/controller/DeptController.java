package org.lanqiao.controller;

import java.util.List;

import org.lanqiao.entity.Dept;
import org.lanqiao.service.DeptService;
import org.lanqiao.service.impl.deptServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/dept")
public class DeptController {
	private DeptService deptService = new deptServiceImpl();
	@RequestMapping("/find")
	@ResponseBody
	public Object find(){
		List<Dept> dept = deptService.queryDeptAll();
		return dept;
	}
}
