<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>JSP Project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<link href="../layout/styles/layout.css" rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<style type="text/css">
*{
  font-family: 'Do Hyeon', sans-serif;
}
</style>
<link rel="stylesheet" href="../member/shadow/css/shadowbox.css">
<script type="text/javascript" src="../member/shadow/js/shadowbox.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

<script type="text/javascript">
Shadowbox.init({
	players:['iframe']
})
$(function(){
	$('.images').css("cursor","pointer")
	$('#logImg').click(function(){
		Shadowbox.open({
			content:'../member/login.do',
			player:'iframe',
			title:'Login',
			width:480,
			height:260
		})
	})
	$('#logoutImg').click(function(){
		location.href="../member/logout.do";
	})
	// store를 별도로 출력
	$('#storeImg').click(function(){
		// 화면 이동 
		location.href="../goods_main/goods_main.do"
	})
})
</script>
</head>
<body id="top">
  <jsp:include page="header.jsp"></jsp:include>
  <jsp:include page="${main_jsp }"></jsp:include>
  <jsp:include page="footer.jsp"></jsp:include>
<a id="backtotop" href="#top"><i class="fa fa-chevron-up"></i></a> 
<!-- JAVASCRIPTS --> 
<script src="../layout/scripts/jquery.min.js"></script> 
<script src="../layout/scripts/jquery.backtotop.js"></script> 
<script src="../layout/scripts/jquery.mobilemenu.js"></script> 
<script src="../layout/scripts/jquery.flexslider-min.js"></script>
</body>
</html>