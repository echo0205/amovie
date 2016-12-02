package org.lanqiao.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/UserLogin")
public class LoginController {
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(HttpServletRequest request){
		String userName = request.getParameter("name");
		HttpSession session = request.getSession();
		session.setAttribute("userName", userName);
		return "redirect:/emp/select";
	}
}
