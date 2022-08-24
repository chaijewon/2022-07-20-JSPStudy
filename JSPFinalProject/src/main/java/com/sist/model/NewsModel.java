package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.manager.*;
@Controller
public class NewsModel {
    @RequestMapping("news/news_list.do")
    public String news_list(HttpServletRequest request,HttpServletResponse response)
    {
    	try
    	{
    		request.setCharacterEncoding("UTF-8");
    	}catch(Exception ex){}
    	String fd=request.getParameter("fd");
    	if(fd==null)
    		fd="맛집";
    	List<NewsVO> list=NewsManager.newsFind(fd);
    	for(NewsVO vo:list)
    	{
    		String day=new SimpleDateFormat("yyyy-MM-dd").format(new Date(vo.getRegdate()));
    		vo.setRegdate(day);
    	}
    	request.setAttribute("list", list);
    	request.setAttribute("main_jsp", "../news/news_list.jsp");
    	return "../main/main.jsp";
    }
}
