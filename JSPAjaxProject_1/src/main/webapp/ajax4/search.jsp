<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
     List<MovieVO> list=MovieDAO.movieSearchData();
     request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 1200px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$('#fd').keyup(function(){
		let fd=$('#fd').val();
		$('#user-table > tbody > tr').hide();
		let temp=$('#user-table > tbody > tr > td:nth-child(5n+2):contains("'+fd+'")')
		$(temp).parent().show()
	})
	// $('.details').click(function(){})
	$('.details').on('click',function(){
		let mno=$(this).attr("data-no")
		//alert(mno+"")
		$.ajax({
			type:'post',
			url:'detail.jsp',
			data:{"mno":mno},
			success:function(result)
			{
				$('#dialog').html(result)
				$('#dialog').dialog({
					autoOpen:false,
					width:'520',
					height:'800',
					modal:true
				}).dialog("open")
			}
		})
		
	})
})
</script>
</head>
<body>
 <div class="container">
    <div class="row">
      <div class="text-center">
         Search:<input type=text size=45 class="input-sm" id="fd" name="fd">
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <table class="table" id="user-table">
        <thead>
	        <tr class="danger">
	          <th class="text-center"></th>
	          <th class="text-center">영화명</th>
	          <th class="text-center">감독</th>
	          <th class="text-center">장르</th>
	          <th class="text-center"></th>
	        </tr>
        </thead>
        <tbody>
        <c:forEach var="vo" items="${list }">
          <tr>
            <td class="text-center">
             <img src="${vo.poster }" style="width: 30px;height: 30px">
            </td>
            <td>${vo.title }</td>
            <td>${vo.director }</td>
            <td>${vo.genre }</td>
            <td class="text-center">
              <input type=button value="상세보기" class="btn btn-sm btn-primary details"
                data-no="${vo.mno }"
              >
            </td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
    <div id="dialog" title="영화 상세">
     
   </div>
 </div>
</body>
</html>






