package com.sist.controller;

import java.io.*;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("사용자 요청 진입...");
		//EmpModel model=new EmpModel();
		System.out.println("요청 처리...");
		//model.empListData(request);
		try
		{
			Class clsName=Class.forName("com.sist.model.EmpModel");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods=clsName.getDeclaredMethods();
			methods[0].invoke(obj, request);
			// 메소드명은 개발자 마음대로 제작 
		}catch(Exception ex){}
		System.out.println("request에 결과값을 채운다");
		//request를 JSP로 전송 
		RequestDispatcher rd=request.getRequestDispatcher("../emp/emp.jsp");
		rd.forward(request, response);
		
	}

}







