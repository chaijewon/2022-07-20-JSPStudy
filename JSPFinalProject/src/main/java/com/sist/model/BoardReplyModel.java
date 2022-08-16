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
	   int totalpage=BoardReplyDAO.boardReplyTotalPage();
	   
	   request.setAttribute("totalpage", totalpage);
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
   @RequestMapping("board_reply/insert_ok.do")
   public String board_reply_insert_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   // 데이터베이스 처리 
	   try
	   {
            request.setCharacterEncoding("UTF-8"); // 한글 처리 		   
	   }catch(Exception ex) {}
	   String name=request.getParameter("name");
	   String subject=request.getParameter("subject");
	   String content=request.getParameter("content");
	   String pwd=request.getParameter("pwd");
	   String pno=request.getParameter("pno");
	   BoardReplyVO vo=new BoardReplyVO();
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);
	   
	   BoardReplyDAO.boardReplyInsertOk(Integer.parseInt(pno),vo);
	   return "redirect:../board_reply/list.do"; // insert_ok , update_ok , delete_ok
	   // 데이터 전송은 없고 처리후 이전에 실행된 화면으로 이동 (list,detail)
   }
   // board_reply/detail.do
   @RequestMapping("board_reply/detail.do")
   public String board_reply_detail(HttpServletRequest request,HttpServletResponse response)
   {
	   // board_reply/detail.do?no=${vo.no }
	   // C/S ==> 주고 받기 
	   // Client (요청 => 데이터 전송) => ?
	   // Server (요청 처리 => 결과값 => request,session => setAttribute())
	   // primary key , 검색어 , id(보안유지 => session) , page
	   // 장바구니 => 번호 
	   String no=request.getParameter("no");
	   BoardReplyVO vo=BoardReplyDAO.boardReplyDetailData(Integer.parseInt(no));
	   request.setAttribute("vo", vo);
	   request.setAttribute("main_jsp", "../board_reply/detail.jsp");
	   return "../main/main.jsp";
   }
   // .do ==> 처리 (Model)  board_reply/update.do?no=${vo.no }
   @RequestMapping("board_reply/update.do")
   public String board_reply_update(HttpServletRequest request,HttpServletResponse response)
   {
	   // 출력할 데이터 전송 
	   request.setAttribute("main_jsp", "../board_reply/update.jsp");
	   return "../main/main.jsp";
   }
}














