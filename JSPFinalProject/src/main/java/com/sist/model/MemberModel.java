package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class MemberModel {
   @RequestMapping("member/login.do")
   public String member_login(HttpServletRequest request,HttpServletResponse response)
   {
	   System.out.println("Login");
	   return "../member/login.jsp";
   }
}
