package com.sist.controller;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;
@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// URI  recipe/list.do  /JSPMVCProject_1/recipe/detail.do
		String uri=request.getRequestURI();
		//System.out.println(uri);
		uri=uri.substring(request.getContextPath().length()+1);
		//System.out.println(uri);
		EmpModel model=new EmpModel();
		String jsp="";
		if(uri.equals("emp/list.do")) //annotation @RequestMapping("emp/list.do")
		{
			model.empListData(request);//HandlerMapping
			jsp="../emp/list.jsp"; // ViewResolver
		}
		else if(uri.equals("emp/detail.do")) // @RequestMapping("emp/deail.do")
		{
			model.empDetailData(request);
			jsp="../emp/detail.jsp";
		}
		
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}

}
