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
	   List<FoodVO> list=FoodDAO.foodListData(Integer.parseInt(cno));
	   FoodCategoryVO vo=FoodDAO.foodCategoryInfoData(Integer.parseInt(cno));
	   request.setAttribute("list", list);
	   request.setAttribute("vo", vo);
	   request.setAttribute("main_jsp", "../food/food_list.jsp");
	   return "../main/main.jsp";//forward
   }
   
   // 쿠키 전송 
   @RequestMapping("food/food_detail_before.do")
   public String food_detail_before(HttpServletRequest request,HttpServletResponse response)
   {
	   // 쿠키 전송 => 화면 출력 (X)
	   // insert_ok.do ==> list.do
	   // => 상세보기로 이동 
	   return "redirect:../food/food_detail.do";//request초기화 => 화면 이동 (sendRedirect())
   }
}







