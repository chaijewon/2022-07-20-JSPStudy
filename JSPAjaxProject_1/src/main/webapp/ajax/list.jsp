<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="//code.jquery.com/jquery.js"></script>
<script type="text/javascript">
/*
 *    자바스크립트 => 내장 객체 
         window (브라우저) 
           |
       -----------------------
       |          |          |
      document  location  history
      --------  --------  -------
       출력        화면이동    저장 
 */
$(function(){ // window.onload=function(){} , $(document).ready(function(){})
	// 태그를 제어 => 선택자 (CSS) ==> 이벤트 
	// 태그 $('input[type="button"]') , ID $('#아이디명') , Class $('.class명')
	// 자손 $('table > tr'), 후손 $('table tr') , 인접 $('p+div') 
	// css() , hover() , click() , change() , keyup() , enter()
	$('#btn').click(function(){
		//location.href="detail.jsp";
		$.ajax({
			type:'post',
			url:'detail.jsp',
			success:function(res)
			{
				$('#print').html(res);
			}
		})
	})
})
</script>
</head>
<body>
 <input type="button" value="읽기" id="btn">
 <p>
 <div id="print"></div>
</body>
</html>





