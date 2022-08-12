<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'get',
		url:'include.jsp',
		success:function(result)
		{
			$('#print').html(result)
		}
	})
})
</script>
</head>
<body>
  <div id="print">
    
  </div>
</body>
</html>