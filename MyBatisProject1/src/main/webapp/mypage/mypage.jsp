<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="../css/mypage/mypage.css">
  <link rel="icon" type="image/png" href="../favicon.ico">
  
  <!-- 아이콘 -->
  <link rel="stylesheet" href="../css/font-awesome.min.css">
  
  <!-- 부트스트랩 -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="../css/bootsnav.css">
  
  <!-- 슬라이더 -->
  <link rel="stylesheet" type="text/css" href="../css/slick/slick.css">
  <link rel="stylesheet" type="text/css" href="../css/slick/slick-theme.css">
  
  <!-- 섀도우박스 -->
  <link rel="stylesheet" href="../shadow/css/shadowbox.css">
  <script type="text/javascript" src="../shadow/js/shadowbox.js"></script>
  
  <!-- 커스텀 css -->
  <link rel="stylesheet" href="../css/style.css">
  
  <!-- Jquery -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  
  <!-- Jquery UI --> 
  <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
  
  <script src="../js/modernizr-2.8.3-respond-1.4.2.min.js"></script>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
<div class="container">
  <div class="row m-top-40">
    <div class="col-sm-3">
      <jsp:include page="menu.jsp"></jsp:include>
    </div>
    <div class="col-sm-9 m-top-20">
      <jsp:include page="${content_jsp }"></jsp:include>
    </div>
  </div>
</div>
</body>
</html>