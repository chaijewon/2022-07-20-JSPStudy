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
	$('.reserves').click(function(){
		let no=$(this).attr("data-no");
		$.ajax({
			type:'post',
			url:'../reserve/reserve_info.do',
			data:{"no":no},
			success:function(result)
			{
				$('#print').html(result);
			}
		})
	})
})
</script>
</head>
<body>
  <h2 class="sectiontitle">예약목록</h2>
    <table class="table">
      <tr>
        <th class="text-center"></th>
        <th class="text-center">업체명</th>
        <th class="text-center">전화</th>
        <th class="text-center">예약일</th>
        <th class="text-center">예약시간</th>
        <th class="text-center">인원</th>
        <th class="text-center"></th>
      </tr>
      <c:forEach var="vo" items="${list }">
        <tr>
          <td class="text-center">
            <img src="${vo.poster }" style="width: 30px;height: 30px">
          </td>
          <td><a href="#">${vo.name }</a></td>
          <td>${vo.tel }</td>
          <td class="text-center">${vo.rday }</td>
          <td class="text-center">${vo.rtime }</td>
          <td class="text-center">${vo.inwon }명</td>
          <td class="text-center">
           <c:if test="${vo.ischeck=='n' }">
            <span class="btn btn-xs btn-danger">예약대기</span>
            <a href="../reserve/reserve_cancel.do?no=${vo.no }" class="btn btn-xs btn-primary">취소</a>
           </c:if>
           <c:if test="${vo.ischeck=='y' }">
            <span class="btn btn-xs btn-default reserves" data-no="${vo.no }">예약완료</span>
           </c:if>
          </td>
        </tr>
      </c:forEach>
    </table>
    <div style="height: 30px"></div>
    <div id="print">
      
    </div>
</body>
</html>