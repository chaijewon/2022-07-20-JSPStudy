package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class MainModel {
   @RequestMapping("main/main.do")
   public String main_page(HttpServletRequest request,HttpServletResponse response)
   {
	   Cookie[] cookies=request.getCookies();
	   List<FoodVO> cList=new ArrayList<FoodVO>();
	   if(cookies!=null)
	   {
		   for(int i=cookies.length-1;i>=0;i--)
		   {
			   if(cookies[i].getName().startsWith("food"))
			   {
				   String fno=cookies[i].getValue();
				   FoodVO vo=FoodDAO.foodDetailData(Integer.parseInt(fno));
				   cList.add(vo);
			   }
		   }
	   }
	   request.setAttribute("cList", cList);
	   List<FoodCategoryVO> list=FoodDAO.foodCategoryData();
	   request.setAttribute("list", list);
	   request.setAttribute("main_jsp", "../main/home.jsp");// 데이터 출력
	   
	   return "../main/main.jsp"; // include
   }
   
}
