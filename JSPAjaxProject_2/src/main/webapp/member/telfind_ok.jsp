<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
     request.setCharacterEncoding("UTF-8");
     String name=request.getParameter("name");
     String tel=request.getParameter("tel");
     String result=MemberDAO.telIdFind(name, tel);
     request.setAttribute("result", result);
%>
${result}