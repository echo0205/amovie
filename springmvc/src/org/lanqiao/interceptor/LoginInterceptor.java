package org.lanqiao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object object) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		HttpSession session = request.getSession();
		Object userName = session.getAttribute("userName");
		String requestURI = request.getRequestURI();
		System.out.println("requestURI--->"+requestURI);
		if(!("/emp/*").equals(requestURI)){
			if(userName==null){
				flag = false;
				response.sendRedirect("/springmvc/view/login");
			}
		}
		return flag;
	}

}
