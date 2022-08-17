package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class ReserveModel {
    @RequestMapping("reserve/reserve.do")
    public String reserve_main(HttpServletRequest request,HttpServletResponse response)
    {
    	request.setAttribute("main_jsp", "../reserve/reserve.jsp");
    	return "../main/main.jsp";
    }
    // _ok.do , ajax 
    @RequestMapping("reserve/food_list.do")
    public String reserve_food_list(HttpServletRequest request,HttpServletResponse response)
    {
    	String type=request.getParameter("type");
    	if(type==null)
    		type="한식";
    	// 데이터 읽기 
    	List<FoodVO> list=ReserveDAO.reserveFoodData(type);
    	// 데이터 => 해당 JSP로 전송 
    	request.setAttribute("list", list);
    	return "../reserve/food_list.jsp";
    }
    
    // 달력 
    @RequestMapping("reserve/reserve_date.do")
    public String reserve_date(HttpServletRequest request,HttpServletResponse response)
    {
    	String fno=request.getParameter("fno");
    	String today=new SimpleDateFormat("yyyy-M-d").format(new Date());
    	StringTokenizer st=new StringTokenizer(today,"-");
    	String strYear=st.nextToken();
    	String strMonth=st.nextToken();
    	String strDay=st.nextToken();
    	
    	int year=Integer.parseInt(strYear);
    	int month=Integer.parseInt(strMonth);
    	int day=Integer.parseInt(strDay);
    	
    	Calendar cal=Calendar.getInstance();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month-1);
    	cal.set(Calendar.DATE, 1);
    	
    	int week=cal.get(Calendar.DAY_OF_WEEK);
    	int lastday=cal.getActualMaximum(Calendar.DATE);
    	
    	// DAO => 예약이 가능한 날 체크 
    	
    	return "../reserve/reserve_date.jsp";
    }
}








