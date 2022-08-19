<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="./style.css">
<script  src="./script.js"></script>
</head>
<body>
  <jsp:include page="goods_header.jsp"></jsp:include>
  <jsp:include page="${goods_jsp }"></jsp:include>
</body>
</html>