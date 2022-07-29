package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FoodModel {
   @RequestMapping("food/food_list.do")// 카테고리별 맛집 리스트
   public String food_list(HttpServletRequest request,HttpServletResponse response)
   {
	   // 카테고리 번호 
	   String cno=request.getParameter("cno");
	   // cno ==> DAO ==> 데이터 읽기
	   request.setAttribute("main_jsp", "../food/food_list.jsp");
	   return "../main/main.jsp";
   }
}
