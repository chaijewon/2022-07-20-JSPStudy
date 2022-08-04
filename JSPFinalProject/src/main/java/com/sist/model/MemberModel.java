package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
@Controller
public class MemberModel {
   // 아이디 중복체크 
   @RequestMapping("member/idcheck.do")
   public String member_idcheck(HttpServletRequest request,HttpServletResponse response)
   {
	   return "../member/idcheck.jsp";
   }
   @RequestMapping("member/idcheck_ok.do")
   public String member_idcheck_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   String id=request.getParameter("id");
	   int count=MemberDAO.memberIdCheck(id);
	   request.setAttribute("count", count);
	   return "../member/idcheck_ok.jsp";
   }
   
   @RequestMapping("member/login.do")
   public String member_login(HttpServletRequest request,HttpServletResponse response)
   {
	   
	   return "../member/login.jsp";
   }
   
   @RequestMapping("member/join.do")
   public String member_join(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("main_jsp", "../member/join.jsp");
	   return "../main/main.jsp";
   }
}
