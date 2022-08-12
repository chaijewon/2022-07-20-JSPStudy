<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('.food_info').css("cursor","pointer")
	$('.food_info').click(function(){
		let poster=$(this).attr("data-poster");
		$('#rImg').attr("src",poster)
	})
})
</script>
</head>
<body>
  <table class="table">
       <c:forEach var="vo" items="${list }">
        <tr class="food_info" data-poster="${vo.poster }">
         <td>
           <img src="${vo.poster }" style="width: 30px;height: 30px">
         </td>
         <td>${vo.name }</td>
        </tr>
       </c:forEach>
     </table>
</body>
</html>