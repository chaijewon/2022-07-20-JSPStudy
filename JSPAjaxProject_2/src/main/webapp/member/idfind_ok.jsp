<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    request.setCharacterEncoding("UTF-8");
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    String result=MemberDAO.emailIdFind(name, email);
    request.setAttribute("result", result);
%>
${result }

