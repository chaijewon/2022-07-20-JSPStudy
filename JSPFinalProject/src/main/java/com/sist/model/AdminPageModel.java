package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.BoardReplyDAO;

import java.util.*;
import com.sist.vo.*;
@Controller
public class AdminPageModel {
	   @RequestMapping("adminpage/adminpage.do")
	   public String adminpage_main(HttpServletRequest request,HttpServletResponse response)
	   {
		   request.setAttribute("admin_jsp", "../adminpage/adminhome.jsp");
		   request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
		   return "../main/main.jsp";
	   }
	   @RequestMapping("adminpage/reply.do")
	   public String adminpage_reply(HttpServletRequest request,HttpServletResponse response)
	   {
		   List<BoardReplyVO> list=BoardReplyDAO.boardReplyAdminData();
		   request.setAttribute("list", list);
		   request.setAttribute("admin_jsp", "../adminpage/reply.jsp");
		   request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
		   return "../main/main.jsp";
	   }
	   @RequestMapping("adminpage/detail.do")
	   public String adminpage_detail(HttpServletRequest request,HttpServletResponse response)
	   {
		   String no=request.getParameter("no");
		   BoardReplyVO vo=BoardReplyDAO.boardReplyDetailData(Integer.parseInt(no));
		   request.setAttribute("vo", vo);
		   request.setAttribute("admin_jsp", "../adminpage/detail.jsp");
		   request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
		   return "../main/main.jsp";
	   }
	   @RequestMapping("adminpage/reply_insert.do")
	   public String adminpage_reply_insert(HttpServletRequest request,HttpServletResponse response)
	   {
		   return "redirect:../adminpage/reply.do";
	   }
}
