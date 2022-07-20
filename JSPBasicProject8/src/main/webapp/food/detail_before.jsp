<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
      String fno=request.getParameter("no");
      Cookie cookie=new Cookie("f"+fno,fno);// 중복이 없다
      cookie.setPath("/");
      cookie.setMaxAge(60*60*24);
      response.addCookie(cookie);
      //이동 
      response.sendRedirect("food_detail.jsp?no="+fno); 
      /*
           이동 / 데이터 전송 
           -------------- 
            GET 
              자바스크립트 : location.href 
              HTML : <a> , <form> 
              자바: sendRedirect , forward 
            POST
              자바스크립트 : ajax , axios (RestFul)  => List => [] , VO => {} => JSON
              HTML : <form> 
              
      */
%>