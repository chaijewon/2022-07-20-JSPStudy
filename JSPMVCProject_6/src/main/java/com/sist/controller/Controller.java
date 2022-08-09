package com.sist.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		uri=uri.substring(request.getContextPath().length()+1);
		// /JSPMVCProject_1/emp/detail.do
		try
		{
			Class clsName=Class.forName("com.sist.model.EmpModel");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m:methods)
			{
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				if(rm.value().equals(uri))
				{
					String jsp=(String)m.invoke(obj, request);
					RequestDispatcher rd=request.getRequestDispatcher(jsp);
					rd.forward(request, response);
					return;
				}
			}
		}catch(Exception ex) {}
	}
    
}
