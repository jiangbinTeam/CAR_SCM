package com.scm.HandlerInterceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.filefilter.TrueFileFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sun.xml.internal.ws.api.client.ThrowableInPacketCompletionFeature;


public class MyHandlerInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("after");
		
	 
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
	/*	HttpSession session=arg0.getSession();
		Object user=session.getAttribute("user");
	System.out.println("11111");
		if(user!=null) {
			return  true;
		}else {
			PrintWriter writer=arg1.getWriter();
			writer.write("<script>window.top.location.href='login.jsp';</script>");
		}
		return false;*/
		
		return true;
	
	}
	public static void main(String[] args) {
		int[] i=new int[10];
		System.out.println(i[9]);
	}
}
