package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
/*
 *   String[] guList = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
				"은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
				"성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
				"강동구" };
 */
@Controller
public class FoodModel {
    @RequestMapping("food/food_find.do")
    public String food_find(HttpServletRequest req,HttpServletResponse res)
    {
    	return "../food/food_find.jsp";
    }
    @RequestMapping("food/food_find_ok.do")
    public String foood_find_ok(HttpServletRequest req,HttpServletResponse res)
    {
    	String[] guList = { "전체", "강서구", "양천구", "구로구", "마포구", "영등포구", "금천구",
				"은평구", "서대문구", "동작구", "관악구", "종로구", "중구", "용산구", "서초구", "강북구",
				"성북구", "도봉구", "동대문구", "성동구", "강남구", "노원구", "중랑구", "광진구", "송파구",
				"강동구" };
    	String no=req.getParameter("no");
    	String gu=guList[Integer.parseInt(no)];
    	req.setAttribute("gu", gu);
    	return "../food/food_find_ok.jsp";
    }
}















