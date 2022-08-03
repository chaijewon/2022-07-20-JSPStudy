package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class FreBoardModel {
   @RequestMapping("freeboard/list.do")
   public String freeboard_list(HttpServletRequest request,HttpServletResponse response)
   {
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(curpage*rowSize)-(rowSize-1);
	   int end=curpage*rowSize;
	   map.put("start", start);
	   map.put("end",end);
	   List<FreeBoardVO> list=FreeBoardDAO.boardListData(map);
	   int totalpage=FreeBoardDAO.boardTotalPage();
	   
	   request.setAttribute("curpage", curpage);
       request.setAttribute("totalpage", totalpage);
       request.setAttribute("list", list);
	   request.setAttribute("main_jsp", "../freeboard/list.jsp");
	   return "../main/main.jsp";
   }
}







