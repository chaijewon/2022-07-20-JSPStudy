<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--  쿠키 처리 
      jsp => response 전송 (response를 한번만 사용이 가능)
      ----------------------------------------------
      HTML / Cookie
--%>
<%
      String mno=request.getParameter("mno");
      Cookie cookie=new Cookie("movie"+mno,mno);
      cookie.setPath("/");
      cookie.setMaxAge(60*60*24);
      // 클라이언트로 전송
      response.addCookie(cookie);
      
      response.sendRedirect("detail.jsp?mno="+mno);
%>