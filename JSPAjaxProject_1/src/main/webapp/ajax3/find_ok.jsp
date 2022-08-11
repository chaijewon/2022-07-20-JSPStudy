<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
     request.setCharacterEncoding("UTF-8");
     // <form method=post action="find.jsp"> => find.jsp에서 처리
     // <a href="a.jsp?no=1111"> => a.jsp
     String fd=request.getParameter("fd");
     if(fd==null)
    	 fd="비"; //자신JSP에서 처리 => 디폴트 
     
     List<MovieVO> list=MovieDAO.movieFindData(fd);
     // HTML은 출력 , 데이터 읽기 (자바)
     request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <c:forEach var="vo" items="${list }">
        <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="detail_before.do?mno=${ vo.getMno()}">
	          <img src="${vo.getPoster() }" alt="Lights" style="width:290px;height: 300px">
	          <div class="caption">
	            <p>${vo.getTitle()}</p>
	          </div>
	        </a>
	      </div>
	    </div>
      </c:forEach>
</body>
</html>