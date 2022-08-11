<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$('#btn').click(function(){
		$.ajax({
			type:'post',
			url:'tes.jsp',
			success:function(res)
			{
				//alert(res)
				let info=res
				$('#info').html(info);
				$( "#dialog" ).dialog({
					autoOpen:false,
					width:'auto',
					height:'auto',
					modal:true
				}).dialog("open");
			}
		})
	})
})
</script>
</head>
<body>
 <input type=button value="읽기" id="btn">
 <p>
 <div id="dialog" title="Basic dialog">
  <ul id="info">
   
  </ul>
 </div>
</body>
</html>