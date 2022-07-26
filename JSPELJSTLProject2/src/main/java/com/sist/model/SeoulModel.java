package com.sist.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.LocationDAO;
import com.sist.dao.LocationVO;

// EL/JSTL ==> MVC용 ==> JSP에서 자바 코딩을 최소화 
public class SeoulModel {
  public void locationListData(HttpServletRequest request)
  {
	    LocationDAO dao=new LocationDAO();
	    String strPage=request.getParameter("page");
	    if(strPage==null)
	    	strPage="1";
	    int curpage=Integer.parseInt(strPage);
	    List<LocationVO> list=dao.locationListData(curpage);
	    
	    // 총페이지 
	    int totalpage=dao.locationTotalPage();
	    
	    final int BLOCK=5;
	    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	    
	    // [1]...[5]  curpage=1~5 4/5
	    // [6]...[10] startPage= 6  , endPage=10  ==> curpage=6~10
	    if(endPage>totalpage)
	    	 endPage=totalpage;
	    
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("totalpage", totalpage);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("list", list);
	    // request.getAttribute("curpage") => ${curpage}
  }
  public void locationDetailData(HttpServletRequest request)
  {
	  LocationDAO dao=new LocationDAO();
	  String no=request.getParameter("no");
	  LocationVO vo=dao.locationDetailData(Integer.parseInt(no));
	  request.setAttribute("vo", vo);
  }
  
  public void natureListData(HttpServletRequest request)
  {
	    LocationDAO dao=new LocationDAO();
	    String strPage=request.getParameter("page");
	    if(strPage==null)
	    	strPage="1";
	    int curpage=Integer.parseInt(strPage);
	    List<LocationVO> list=dao.natureListData(curpage);
	    
	    // 총페이지 
	    int totalpage=dao.natureTotalPage();
	    
	    final int BLOCK=5;
	    int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	    int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	    
	    // [1]...[5]  curpage=1~5 4/5
	    // [6]...[10] startPage= 6  , endPage=10  ==> curpage=6~10
	    if(endPage>totalpage)
	    	 endPage=totalpage;
	    
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("totalpage", totalpage);
	    request.setAttribute("startPage", startPage);
	    request.setAttribute("endPage", endPage);
	    request.setAttribute("list", list);
  }
  public void natureDetailData(HttpServletRequest request)
  {
	  LocationDAO dao=new LocationDAO();
	  String no=request.getParameter("no");
	  LocationVO vo=dao.natureDetailData(Integer.parseInt(no));
	  request.setAttribute("vo", vo);
  }
}
