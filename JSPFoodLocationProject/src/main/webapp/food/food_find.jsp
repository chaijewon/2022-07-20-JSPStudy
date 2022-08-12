<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="food.css">
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
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.gus').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
			type:'post',
			url:'food_find_ok.do',
			data:{"no":no},
			success:function(result)
			{
				$('#print').html(result);// innerHTML(include)
			}
		})
	})
})
</script>
</head>
<body>
  <div class="container">
    <div class="row">
     <c:forEach var="i" begin="1" end="25">
       <img src="map/gu_${i }_off.png" id="gu${i }" 
       onmouseover="this.src='map/gu_${i}_on.png'" onmouseout="this.src='map/gu_${i}_off.png'"
        class="gus" data-no="${i }"
       >
     </c:forEach>
    </div>
    <div style="height: 20px"></div>
    <div class="row" id="print">
     
    </div>
  </div>
</body>
</html>