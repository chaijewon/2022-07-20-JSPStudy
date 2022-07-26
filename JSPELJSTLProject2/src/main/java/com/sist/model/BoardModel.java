package com.sist.model;
import java.util.*;
import java.text.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
public class BoardModel {
   public void boardListData(HttpServletRequest request)
   {
	   ReplyBoardDAO dao=new ReplyBoardDAO();
	   String page=request.getParameter("page");
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   List<ReplyBoardVO> list=dao.boardListData(curpage);
	   int count=dao.boardRowCount();
	   int totalpage=(int)(Math.ceil(count/10.0));
	   count=count-((curpage*10)-10);
	   // jsp로 결과값 전송 
	   request.setAttribute("curpage", curpage);
	   request.setAttribute("totalpage", totalpage);
	   request.setAttribute("count", count);
	   request.setAttribute("list", list);
	   String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	   request.setAttribute("today", today);
   }
   // 글쓰기 
   public void boardInsert(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   String name=request.getParameter("name");
	   String subject=request.getParameter("subject");
	   String content=request.getParameter("content");
	   String pwd=request.getParameter("pwd");
	   
	   ReplyBoardVO vo=new ReplyBoardVO();
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);
	   
	   ReplyBoardDAO dao=new ReplyBoardDAO();
	   dao.boardInsert(vo);
	   
	   // 이동 
	   try
	   {
	     response.sendRedirect("list.jsp");
	   }catch(Exception ex){}
	   // JSP는 화면에 출력 , 모든 처리=Java에서 한다 ==> MVC
	   // Model ==> vo,dao,model...
   }
   // 상세보기 
   public void boardDetailData(HttpServletRequest request)
   {
	   // detail.jsp?no=${vo.no }
	   String no=request.getParameter("no");
	   ReplyBoardDAO dao=new ReplyBoardDAO();
	   ReplyBoardVO vo=dao.boardDetailData(Integer.parseInt(no));
	   // JSP로 전송 
	   request.setAttribute("vo", vo);
   }
   
   // ============= JSP(요청) : click ,   입력 , 마우스 =====> MODEL에서 받아서 처리 ==== 결과값 ==> JSP
   // 답변 
   public void boardReplyInsert(HttpServletRequest request,HttpServletResponse response)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   String name=request.getParameter("name");
	   String subject=request.getParameter("subject");
	   String content=request.getParameter("content");
	   String pwd=request.getParameter("pwd");
	   String pno=request.getParameter("pno");// 상위 게시물 
	   
	   ReplyBoardVO vo=new ReplyBoardVO();
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);
	   // insert,update ,delete,reply => 오라클 처리 (화면은 없다) ==> 화면 이동 (list,detail)
	   // DAO연동 
	   ReplyBoardDAO dao=new ReplyBoardDAO();
	   dao.replyInsert(Integer.parseInt(pno), vo);
	   // 화면이동 (list.jsp) redux,vuex , react vue
	   try
	   {
	      response.sendRedirect("list.jsp");
	   }catch(Exception ex){}
   }
   public void boardUpdateData(HttpServletRequest request)
   {
	   // update.jsp?no=${vo.no }
	   String no=request.getParameter("no");
	   // DAO에서 데이터 읽기
	   ReplyBoardDAO dao=new ReplyBoardDAO();
	   ReplyBoardVO vo=dao.boardUpdateData(Integer.parseInt(no));
	   // 읽은 데이터를 request에 담아서 넘겨준다 (update.jsp)
	   request.setAttribute("vo", vo);
   }
   public void boardUpdateOk(HttpServletRequest request)
   {
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   String name=request.getParameter("name");
	   String subject=request.getParameter("subject");
	   String content=request.getParameter("content");
	   String pwd=request.getParameter("pwd");
	   String no=request.getParameter("no");// 상위 게시물 
	   
	   ReplyBoardVO vo=new ReplyBoardVO();
	   vo.setName(name);
	   vo.setSubject(subject);
	   vo.setContent(content);
	   vo.setPwd(pwd);
	   vo.setNo(Integer.parseInt(no));
	   // DAO연동 
	   ReplyBoardDAO dao=new ReplyBoardDAO();
	   // 결과값 전송
	   boolean bCheck=dao.boardUpdate(vo);
	   request.setAttribute("bCheck", bCheck);
	   request.setAttribute("no", no);
   }
}










