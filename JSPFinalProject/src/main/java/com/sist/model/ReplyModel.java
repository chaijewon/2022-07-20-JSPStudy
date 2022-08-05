package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.RecipeDAO;
import com.sist.dao.ReplyDAO;
import com.sist.vo.ReplyVO;
/*
 *      NO      NOT NULL NUMBER    ==> 자동 증가    
		BNO              NUMBER       
		TYPE             NUMBER     
		--------------------------------  
		ID      NOT NULL VARCHAR2(20) 
		NAME    NOT NULL VARCHAR2(34) 
		-------------------------------- session
		MSG     NOT NULL CLOB         
		REGDATE          DATE  --- SYSDATE   
 */
@Controller
public class ReplyModel {
   @RequestMapping("reply/reply_insert.do")
   public String reply_insert(HttpServletRequest request,HttpServletResponse response)
   {
	   // bno , type ,  msg  ==> id, name  
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   
	   String bno=request.getParameter("bno");// 게시물 번호 
	   String type=request.getParameter("type"); // 카테고리 
	   String msg=request.getParameter("msg");
	   HttpSession session=request.getSession();
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   
	   ReplyVO vo=new ReplyVO();
	   vo.setBno(Integer.parseInt(bno));
	   vo.setId(id);
	   vo.setName(name);
	   vo.setMsg(msg);
	   vo.setType(Integer.parseInt(type));
	   //DAO => 오라클 전송 
	   ReplyDAO.replyInsert(vo);
	   return "redirect:../freeboard/detail.do?no="+bno;
   }
   @RequestMapping("reply/reply_delete.do")
   public String reply_delete(HttpServletRequest request,HttpServletResponse response)
   {
	   String bno=request.getParameter("bno");
	   // 삭제 ==> DAO
	   return "redirect:../freeboard/detail.do?no="+bno;
   }
}
