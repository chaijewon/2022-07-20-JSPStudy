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
      <li><a href="#">맛집</a></li>
      <li><a href="#">지역별 맛집 찾기</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <h2 class="sectiontitle">지역별 맛집 찾기</h2>
    <div class="row inline">
      <form method="post" action="../food/food_find.do">
       <input type=text name=addr size=35 class="input-sm" value="${addr }">
       <input type=submit value="검색" class="btn btn-sm btn-primary">
      </form>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
	    <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="#">
	          <img src="${vo.poster }" style="width:100%">
	          <div class="caption">
	            <p>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></p>
	            <p>${vo.type }</p>
	          </div>
	        </a>
	      </div>
	    </div>
	  </c:forEach>
    </div>
    <div class="row">
      <div class="text-center">
        <a href="../food/food_find.do?addr=${addr }&page=${curpage>1?curpage-1:curpage}" class="btn btn-sm btn-success">이전</a>
        ${curpage } page / ${totalpage } pages
        <a href="../food/food_find.do?addr=${addr }&page=${curpage<totalpage?curpage+1:curpage}" class="btn btn-sm btn-info">다음</a>
      </div>
    </div>
  </main>
</div>
</body>
</html>


