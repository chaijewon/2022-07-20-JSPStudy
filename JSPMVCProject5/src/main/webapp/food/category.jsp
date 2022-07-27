<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
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
.row{
   margin: 0px auto;
   width: 960px;
}
</style>
</head>
<body>
  <div class='container'>
    <div class="row">
     <div class="text-center">
      <a href="category.do?no=1" class="btn btn-sm btn-success">믿고 보는 맛집 리스트</a>
      <a href="category.do?no=2" class="btn btn-sm btn-info">지역별 인기 맛집</a>
      <a href="category.do?no=3" class="btn btn-sm btn-warning">메뉴별 인기 맛집</a>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <%-- for(CategoryVO vo:list) --%>
      <c:forEach var="vo" items="${list }">
        <div class="col-md-4">
	      <div class="thumbnail">
	        <a href="food_list.do?cno=${vo.cno }">
	          <img src="${vo.poster }" alt="Lights" style="width:250px;height: 200px">
	          <div class="caption">
	            <p>${vo.title }</p>
	          </div>
	        </a>
	      </div>
	    </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>








