<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="model" class="com.sist.model.SeoulModel"/>
<%
     model.natureListData(request); // Controller
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <c:forEach var="vo" items="${list }">
       <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="detail.jsp?no=${vo.no }">
	          <img src="${vo.poster }" alt="Lights" style="width:250px;height: 200px">
	          <div class="caption">
	            <p>${vo.title }</p>
	          </div>
	        </a>
	      </div>
	    </div>
     </c:forEach>
    </div>
    <div class="row">
     <div class="text-center">
       <ul class="pagination">
         <%--  1       6    11  ... --%>
         <c:if test="${startPage>1 }">
           <li><a href="nature.jsp?page=${startPage-1 }">&lt;</a></li>
         </c:if>
         
         <c:forEach var="i" begin="${startPage }" end="${endPage }">
           <li ${i==curpage?"class=active":"" }><a href="nature.jsp?page=${i }">${i }</a></li>
         </c:forEach>
         <%--  5      10    15 --%>
         <c:if test="${endPage<totalpage }">
		  <li><a href="nature.jsp?page=${endPage+1 }">&gt;</a></li>
		 </c:if>
		</ul>
     </div>
    </div>
  </div>
</body>
</html>