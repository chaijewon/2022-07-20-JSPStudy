package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.dao.*;
import com.sist.vo.MemberVO;
@Controller
public class MemberModel {
   // 아이디 중복체크 
   @RequestMapping("member/idcheck.do")
   public String member_idcheck(HttpServletRequest request,HttpServletResponse response)
   {
	   return "../member/idcheck.jsp";
   }
   @RequestMapping("member/idcheck_ok.do")
   public String member_idcheck_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   // data:{"id":id}  ?id=aaa
	   String id=request.getParameter("id");
	   int count=MemberDAO.memberIdCheck(id);
	   request.setAttribute("count", count);
	   return "../member/idcheck_ok.jsp";
   }
   
   @RequestMapping("member/email_check.do")
   public String member_email_check(HttpServletRequest request,HttpServletResponse response)
   {
	   // data:{"id":id}  ?id=aaa
	   String email=request.getParameter("email");
	   int count=MemberDAO.memberEmailCheck(email);
	   request.setAttribute("count", count);
	   return "../member/idcheck_ok.jsp";
   }
   
   @RequestMapping("member/tel_check.do")
   public String member_tel_check(HttpServletRequest request,HttpServletResponse response)
   {
	   // data:{"id":id}  ?id=aaa
	   String tel=request.getParameter("tel");
	   int count=MemberDAO.memberTelCheck(tel);
	   request.setAttribute("count", count);
	   return "../member/idcheck_ok.jsp";
   }
   
   @RequestMapping("member/login.do")
   public String member_login(HttpServletRequest request,HttpServletResponse response)
   {
	   
	   return "../member/login.jsp";
   }
   
   @RequestMapping("member/join.do")
   public String member_join(HttpServletRequest request,HttpServletResponse response)
   {
	   request.setAttribute("main_jsp", "../member/join.jsp");
	   return "../main/main.jsp";
   }
   
   @RequestMapping("member/join_ok.do")
   /*
    *          #{id},
		       #{pwd},
		       #{name},
		       #{sex},
		       #{birthday},
		       #{email},
		       #{post},
		       #{addr1},
		       #{addr2},
		       #{tel},
		       #{content}
    */
   public String member_join_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   // 사용자 전송값 받기 
	   try
	   {
		   request.setCharacterEncoding("UTF-8");
	   }catch(Exception ex) {}
	   String id=request.getParameter("id");
	   String pwd=request.getParameter("pwd");
	   String name=request.getParameter("name");
	   String sex=request.getParameter("sex");
	   String birthday=request.getParameter("birthday");
	   String email=request.getParameter("email");
	   String post=request.getParameter("post");
	   String addr1=request.getParameter("addr1");
	   String addr2=request.getParameter("addr2");
	   String tel1=request.getParameter("tel1");
	   String tel2=request.getParameter("tel2");
	   String content=request.getParameter("content");
	   
	   MemberVO vo=new MemberVO();
	   vo.setId(id);
	   vo.setName(name);
	   vo.setPost(post);
	   vo.setPwd(pwd);
	   vo.setSex(sex);
	   vo.setBirthday(birthday);
	   vo.setEmail(email);
	   vo.setAddr1(addr1);
	   vo.setAddr2(addr2);
	   vo.setTel(tel1+"-"+tel2);
	   vo.setContent(content);
	   // 데이터베이스 연결 
	   System.out.println("email:"+email);
	   // 요청처리 
	   MemberDAO.memberInsert(vo);
	   // 화면 이동 
	   return "redirect:../main/main.do";
   }
   
   // 로그인 처리
   @RequestMapping("member/login_ok.do")
   public String member_login_ok(HttpServletRequest request,HttpServletResponse response)
   {
	   // 사용자 요청값 받기
	   String id=request.getParameter("id");
	   String pwd=request.getParameter("pwd");
	   // DAO연동 ==> mapper(SQL) , dao(메소드 처리)
	   return "../member/login_ok.jsp";//NOID,NOPWD,OK
   }
}






