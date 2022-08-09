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
.container-fluid{
  margin-top: 50px;
}
.row{
  margin: 0px auto;
  width:100%;
}
</style>
</head>
<body>
  <div class="container-fluid">
    <div class="row">
     <c:forEach var="vo" items="${list }">
       <div class="col-md-4">
	      <div class="thumbnail">
	        <a href="#">
	          <img src="${vo.poster }" alt="Lights" style="width:100%">
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