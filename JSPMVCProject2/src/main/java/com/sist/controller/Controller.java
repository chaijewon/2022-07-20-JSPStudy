package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sist.model.*;
import java.util.*;
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map clsMap=new HashMap();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		clsMap.put("list", new ListModel());
		clsMap.put("update", new UpdateModel());
		clsMap.put("insert", new InsertModel());
		clsMap.put("delete", new DeleteModel());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getParameter("cmd");
		// Model 찾기
		Model model=(Model)clsMap.get(cmd);
		// JSP
		String jsp=model.execute(request);
		
		// request 전송 
		RequestDispatcher rs=request.getRequestDispatcher(jsp);
		rs.forward(request, response);
		
	}

}




