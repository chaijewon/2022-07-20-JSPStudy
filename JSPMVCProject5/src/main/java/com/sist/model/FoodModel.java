package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import com.sist.dao.*;
@Controller
public class FoodModel {
	
   @RequestMapping("food/category.do")
   public String food_category(HttpServletRequest request)
   {
	   String no=request.getParameter("no");
	   if(no==null)
		   no="1";
	   FoodDAO dao=new FoodDAO();
	   List<CategoryVO> list=dao.categoryListData(Integer.parseInt(no));
	   request.setAttribute("list", list);
	   return "../food/category.jsp";
   }
   @RequestMapping("food/food_list.do")
   public String food_list(HttpServletRequest request)
   {
	   String cno=request.getParameter("cno");
	   FoodDAO dao=new FoodDAO();
	   List<FoodVO> list=dao.food_list(Integer.parseInt(cno));
	   request.setAttribute("list", list);
	   return "../food/food_list.jsp";
   }
   @RequestMapping("food/detail.do")
   public String food_detail(HttpServletRequest request)
   {
	   System.out.println("detail() Call...");
	   request.setAttribute("msg", "맛집 상세보기 출력!!");
	   return "../food/detail.jsp";
   }
}
