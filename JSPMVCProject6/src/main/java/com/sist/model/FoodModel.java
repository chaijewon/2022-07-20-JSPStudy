package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
/*
 *   public String display(int a, int b);
 *   
 *   display(10)
 */
@Controller
public class FoodModel {
   /*@RequestMapping("food/category.do")
   public String food_categroy(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("msg", "맛집 카테고리!!");
	   return "../food/category.jsp";
   }*/
   
   @RequestMapping("food/list.do")
   public String food_list(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("msg", "카테고리별 맛집 출력!!");
	   request.setAttribute("main_jsp", "../food/list.jsp");
	   return "../main/main.jsp";
   }
   // ===> ajax (단독 실행)
   @RequestMapping("food/detail.do")
   public String food_detail(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("msg", "맛집 상세보기!!");
	   request.setAttribute("main_jsp", "../food/detail.jsp");
	   return "../main/main.jsp";
   }
   
   @RequestMapping("food/location.do")
   public String food_location(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("msg", "지역별 맛집 찾기!!");
	   request.setAttribute("main_jsp", "../food/location.jsp");
	   return "../main/main.jsp";
   }
}









