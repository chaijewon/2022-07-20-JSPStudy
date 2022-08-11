package com.sist.model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;
import com.sist.dao.*;
public class MovieModel {
  public void movie_list(HttpServletRequest request,HttpServletResponse response)
  {
	  String cno=request.getParameter("cno");
	    if(cno==null)
	    	cno="1";
	    
	    String strPage=request.getParameter("page");
	    if(strPage==null)
	    	strPage="1";
	    int curpage=Integer.parseInt(strPage);
	    
	    MovieDAO dao=new MovieDAO();
	    
	    List<MovieVO> list=dao.movieListData(Integer.parseInt(cno), curpage);
	    // ${request.getAttribute()} => request.setAttribute()
	    int totalpage=dao.movieTotalPage(Integer.parseInt(cno));
	    
	    // 쿠키 
	    Cookie[] cookies=request.getCookies(); //쿠키 읽기
	    List<MovieVO> cList=new ArrayList<MovieVO>();
	    if(cookies!=null)
	    {
	    	for(int i=cookies.length-1;i>=0;i--) // 최신부터 출력 
	    	{
	    		if(cookies[i].getName().startsWith("movie")) //movie1
	    		{
	    			String mno=cookies[i].getValue();// 1
	    			MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
	    			cList.add(vo);
	    		}
	    	}
	    }
	    
	    request.setAttribute("cList", cList);
	    request.setAttribute("curpage", curpage);
	    request.setAttribute("totalpage", totalpage);
	    request.setAttribute("list", list);
  }
  public void movie_detail_before(HttpServletRequest request,HttpServletResponse response)
  {
	  String mno=request.getParameter("mno");
      Cookie cookie=new Cookie("movie"+mno,mno);
      cookie.setPath("/");
      cookie.setMaxAge(60*60*24);
      // 클라이언트로 전송
      response.addCookie(cookie);
      
      try {
		response.sendRedirect("detail.do?mno="+mno);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public void movie_detail(HttpServletRequest request,HttpServletResponse response)
  {
	    String mno=request.getParameter("mno");
	    MovieDAO dao=new MovieDAO();
	    MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
	    request.setAttribute("vo", vo);
	    request.setAttribute("day", "01/11");
  }
}
