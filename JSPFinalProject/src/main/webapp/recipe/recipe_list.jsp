<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">레시피</a></li>
      <li><a href="#">레시피목록</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
  <h2 class="sectiontitle">총 <span style="font-size: 45px;color: green">183,111</span>개의 맛있는 레시피가 있습니다.</h2>
   <div class="row">
	  <c:forEach var="vo" items="${list }">
	    <div class="col-md-4">
	      <div class="thumbnail">
	        <a href="#">
	          <img src="${vo.poster }" style="width:100%">
	          <div class="caption">
	            <p>${vo.title }</p>
	            <p>By&nbsp;${vo.chef }</p>
	          </div>
	        </a>
	      </div>
	    </div>
	  </c:forEach>
   </div>
   <%-- 페이지 출력 --%>
   <div class="row3">
     <div class="row" style="margin-left: 350px">
       <ul class="pagination">
         <%--
            startPage = 1, 11 , 21 , 31...
               curpage=10
          --%>
         <c:if test="${startPage>1 }">
		  <li><a href="../recipe/recipe_list.do?page=${startPage-1 }">&laquo;</a></li>
		 </c:if>
			 <c:forEach var="i" begin="${startPage }" end="${endPage }">
			   <c:choose>
			     <c:when test="${i==curpage }">
			       <c:set var="style" value="class=active"/>
			     </c:when>
			     <c:otherwise>
			       <c:set var="style" value=""/>
			     </c:otherwise>
			   </c:choose>
			   <li ${style }><a href="../recipe/recipe_list.do?page=${i }">${i }</a></li>
			 </c:forEach>
		  <c:if test="${endPage<totalpage }">
		   <li><a href="../recipe/recipe_list.do?page=${endPage+1 }">&raquo;</a></li>
		  </c:if>
		</ul>
	 </div>
   </div>
  </main>
</div>
</body>
</html>