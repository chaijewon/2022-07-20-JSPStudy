package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import java.util.*;
import com.sist.dao.*;
@Controller
public class BoardModel {
   @RequestMapping("board/list.do")
   public String board_list(HttpServletRequest request,HttpServletResponse response)
   {
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int start=(curpage*10)-9;
	   int end=curpage*10;
	   map.put("start", start);
	   map.put("end", end);
	   List<BoardVO> list=BoardDAO.boardListData(map);
	   request.setAttribute("list", list);
	   return "../board/list.jsp";
   }
} 







