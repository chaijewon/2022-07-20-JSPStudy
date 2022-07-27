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
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1. 사용자의 요청을 받는다  ==> /Controller?cmd=list
		String cmd=request.getParameter("cmd");
		// 2. 요청처리 => Model을 찾는다 (model => request)
		String jsp="";
		if(cmd.equals("list"))
		{
			ListModel model=new ListModel();
			model.execute(request);
			jsp="list.jsp";
		}
		else if(cmd.equals("update"))
		{
			UpdateModel model=new UpdateModel();
			model.execute(request);
			jsp="update.jsp";
		}
		else if(cmd.equals("delete"))
		{
			DeleteModel model=new DeleteModel();
			model.execute(request);
			jsp="delete.jsp";
		}
		else if(cmd.equals("insert"))
		{
			InsertModel model=new InsertModel();
			model.execute(request);
			jsp="insert.jsp";
		}
		// 3. 결과값 받기 => request.setAttribute()
		// 4. request 전송 => JSP 
		RequestDispatcher rd=request.getRequestDispatcher("view/"+jsp);
		rd.forward(request, response);
	}

}





