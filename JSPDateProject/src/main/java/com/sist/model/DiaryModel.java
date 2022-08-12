package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.text.*;
public class DiaryModel {
  public String diary_main(HttpServletRequest request)
  {
	  Date date=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d"); // ==> 오류 
	  String today=sdf.format(date);// 오늘 날짜 
	  StringTokenizer st=new StringTokenizer(today,"-");
	  String sy=st.nextToken();
	  String sm=st.nextToken();
	  String sd=st.nextToken();
	  // 사용자가 선택을 못하는 경우 (page,검색) => default
	  String strYear=request.getParameter("year");
	  if(strYear==null)
		  strYear=sy;
	  String strMonth=request.getParameter("month");
	  if(strMonth==null)
		  strMonth=sm;
	  
	  int year=Integer.parseInt(strYear);
	  int month=Integer.parseInt(strMonth);
	  int day=Integer.parseInt(sd);
	  
	  request.setAttribute("year", year);
	  request.setAttribute("month", month);
	  request.setAttribute("day", day);
      return "../diary/diary.jsp";	  
  }
  public String diary_ok(HttpServletRequest request)
  {
	  // 처리 ==> 결과값을 ==> request.setAttribute()
	  Date date=new Date();
	  SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d"); // ==> 오류 
	  String today=sdf.format(date);// 오늘 날짜 
	  StringTokenizer st=new StringTokenizer(today,"-");
	  String sy=st.nextToken();
	  String sm=st.nextToken();
	  String sd=st.nextToken();
	  // 사용자가 선택을 못하는 경우 (page,검색) => default
	  String strYear=request.getParameter("year");
	  if(strYear==null)
		  strYear=sy;
	  String strMonth=request.getParameter("month");
	  if(strMonth==null)
		  strMonth=sm;
	  
	  int year=Integer.parseInt(strYear);
	  int month=Integer.parseInt(strMonth);
	  int day=Integer.parseInt(sd);
	  
	  Calendar cal=Calendar.getInstance();
	  cal.set(Calendar.YEAR, year);
	  cal.set(Calendar.MONTH, month-1);//0 ==> (0=1월, 1=2월)
	  cal.set(Calendar.DATE, 1);//8월 1일 => 요일 
	  int week=cal.get(Calendar.DAY_OF_WEEK); // 요일 (각 월 1일자)
	  int lastday=cal.getActualMaximum(Calendar.DATE); // 마지막 날짜 
	  
	  String[] strWeek={"일","월","화","수","목","금","토"};
	  
	  request.setAttribute("year", year);
	  request.setAttribute("month", month);
	  request.setAttribute("day", day);
	  request.setAttribute("week", week-1);
	  request.setAttribute("lastday", lastday);
	  request.setAttribute("strWeek", strWeek);
	  return "../diary/diary_ok.jsp";
  }
}






