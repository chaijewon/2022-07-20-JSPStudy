package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class MainModel {
   @RequestMapping("main/main.do")
   public String main_main(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("msg", "맛집 카테고리!!");
	   request.setAttribute("main_jsp", "../food/category.jsp");
	   return "../main/main.jsp";
   }
}
