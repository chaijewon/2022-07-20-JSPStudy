package com.sist.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;
// 사용자 => URL 이용해서 연결 ==> Controller(요청 처리) ==> Model(분산)
//                           사용자 요청 ==> 요청 처리 ==> 결과값을 JSP전송 
//                                          |
//                                       나눠서 작업 (Model)
// Controller ==> 고정 (Spring.jar) => Spring/Struts => @RequestMapping => jsp

@WebServlet("*.do")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
    /*
     *     http://localhost:8080 /JSPDateProject/diary/diary.do?year=2022&month=8 ==> URL
     *     ----   -------------- ------------------------------ ------------------
     *     port(80)  서버 주소               URI                    request(tomcat)
     *                           ---------------
     *                               Context 
     */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri=request.getRequestURI();
		//  /JSPDateProject/diary/diary.do
		uri=uri.substring(request.getContextPath().length()+1);
		// /JSPDateProject/
		// diary/diary.do
		//  MyBatis (id) / @RequestMapping () ==> 중복이 있으면 => 500
		String jsp="";
		if(uri.equals("diary/diary.do")) // annotation
		{
			// Model클래스의 메소드 => 처리 (요청처리)
			DiaryModel model=new DiaryModel();
			jsp=model.diary_main(request);
		}
		
		// 결과값을  JSP로 전송 
		RequestDispatcher rd=request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}

}












