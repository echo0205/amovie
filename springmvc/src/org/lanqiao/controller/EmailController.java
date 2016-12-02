package org.lanqiao.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lanqiao.entity.EmpQueryVo;
import org.lanqiao.service.EmployeeService;
import org.lanqiao.service.impl.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * ajax邮箱验证
 * @author Rainbow
 *
 */
@Controller
@RequestMapping("/email")
public class EmailController {
	private EmployeeService employeeService = new EmployeeServiceImpl();
/**
 * 方法一：HashMap方式
 * @param param
 * @return
 */
	@RequestMapping(value = "/check", method = RequestMethod.POST)
	@ResponseBody
	public Object check(String param) {
		List<EmpQueryVo> queryList = employeeService.queryList();
		String text = "";
		Map<String, String> map = new HashMap<String, String>();
		for (EmpQueryVo empQueryVo : queryList) {
			String email2 = empQueryVo.getEmp().getEmail();
			if (param.equals(email2)) {
				text = "existed";
				break;
			} else {
				text = "notexisted";
			}
		}
		if (text.equals("existed")) {
			map.put("status", "n");
			map.put("info", "该邮箱已添加");
		} else {
			map.put("status", "y");
			map.put("info", "该邮箱可以添加");
		}
		System.out.println(map);
		return map;
	}
/**
 * 方式二：拼接字符串方式
 * @param param
 * @return
 */
	@RequestMapping(value = "/checkEmail", method = RequestMethod.POST)
	@ResponseBody
	public Object checkEmail(String param) {
		List<EmpQueryVo> queryList = employeeService.queryList();
		StringBuilder json = new StringBuilder();
		String text = "";
		String sta = "";
		String inf = "";
		for (EmpQueryVo empQueryVo : queryList) {
			String email = empQueryVo.getEmp().getEmail();
			if (param.equals(email)) {
				text = "existed";
			} else {
				text = "notexisted";
			}
		}

		if (text.equals("existed")) {
			sta = "n";
			inf = "该邮箱已存在";
		} else {
			sta = "y";
			inf = "该邮箱可以添加";
		}
		 return "{\"status\":\"n\",\"info\":\"y\"}";
//		json.append("\"status\""+":" + "\"" + sta + "\"" + ",");
//		json.append("\"info\""+":" + "\"" + inf + "\"" + "");
//		json.append("\"info\""+":" + "\"" + inf + "\"" + ""+"}"+"");
//		System.out.println(json);
//		return json;
	}
}
