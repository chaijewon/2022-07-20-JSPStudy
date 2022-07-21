<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     session.invalidate();
     //main.jsp로 이동 
     response.sendRedirect("../main/main.jsp");
%>