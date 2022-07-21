<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.MemberDAO"/>
<%--  MemberDAO dao=new MemberDAO() --%>
<%
     // login.jsp=>id,pwd
     // 1. 사용자가 보내준 요청데이터 받기 
     // 2. 데이터베이스 연동 => 요청처리에 필요한 데이터 읽기 
     String id=request.getParameter("id");
     String pwd=request.getParameter("pwd");
     String result=dao.isLogin(id, pwd);
     
     if(result.equals("NOID")) // ID가 없는 상태
     {
%>
         <script>
         alert("아이디가 존재하지 않습니다!!");
         history.back();
         </script>
<%
     }
     else if(result.equals("NOPWD")) // 비밀번호가 틀린 상태 
     {
%>
         <script>
         alert("비밀번호가 틀립니다!!");
         history.back();
         </script>
<%
     }
     else // 로그인 
     {
    	 session.setAttribute("id", id);
         session.setAttribute("name", result);
         
         // main.jsp로 이동 
         response.sendRedirect("../main/main.jsp");
     }
     
    
%>