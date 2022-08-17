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
	
	$(".food_info").hover(function(){
		$(this).css("backgroundColor","#FC6").css("cursor","pointer")
	},function(){
		$(this).css("backgroundColor","#FFF").css("cursor","none")
	})
	
	$('.food_info').click(function(){
		let poster=$(this).attr("data-poster");
		let name=$(this).attr("data-name");
		let fno=$(this).attr("data-no");
		$('#f_name_lab').show();
		$('#f_name').text(name);
		$('#rImg').attr("src",poster);
		
		// 달력 
		$.ajax({
			type:'post',
			url:'../reserve/reserve_date.do',
			data:{"fno":fno},
			success:function(result)
			{
				$('#r_date').html(result);
			}
		})
	})
})
</script>
</head>
<body>
 <table class="table">
       <c:forEach var="vo" items="${list }">
        <tr class="food_info" data-poster="${vo.poster }" data-no="${vo.fno }" data-name="${vo.name }">
         <td>
           <img src="${vo.poster }" style="width: 30px;height: 30px">
         </td>
         <td>${vo.name }</td>
        </tr>
       </c:forEach>
     </table>
</body>
</html>