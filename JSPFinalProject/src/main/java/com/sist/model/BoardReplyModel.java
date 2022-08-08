package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

/*
 *   1. VO :데이터를 모아서 전송 
 *   2. mapper : SQL문장 
 *   3. DAO : 실제 오라클 연결 ==> SQL문장 전송 , 결과값 읽기 
 *   4. Model : JSP로 요청 결과값 전송 
 *   5. JSP : Model에서 보내준 데이터 출력 
 *   ----------------------------------------------- Spring MVC , Spring-BOOT(MVC)
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
import com.sist.vo.*;
@Controller
public class BoardReplyModel {
   @RequestMapping("board_reply/list.do") // URL주소 (클라이언트 == 서버) ==> 주소창 
   public String board_reply_list(HttpServletRequest request,HttpServletResponse response)
   {
	   String page=request.getParameter("page");
	   // 사용자가 전송한 데이터는 => request에 첨부되어 있다 
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   Map map=new HashMap();
	   int rowSize=10;
	   int start=(rowSize*curpage)-(rowSize-1);
	   int end=rowSize*curpage;
	   
	   map.put("start", start);
	   map.put("end", end);
	   List<BoardReplyVO> list=BoardReplyDAO.boardReplyListData(map);
	   
	   request.setAttribute("list", list);
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("main_jsp", "../board_reply/list.jsp");
	   return "../main/main.jsp";// 화면 출력 관리 
   }
   @RequestMapping("board_reply/insert.do")
   public String board_reply_insert(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("main_jsp", "../board_reply/insert.jsp");
	   return "../main/main.jsp";
   }
   
}














