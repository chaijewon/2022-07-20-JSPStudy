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
   width: 1200px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:'post',
		url:'select.do',
		success:function(result)
		{
			$('#food').html(result);
		}
	})
	$('#type').change(function(){
		let type=$(this).val();
		$.ajax({
			type:'post',
			url:'select.do',
			data:{"type":type},
			success:function(result)
			{
				$('#food').html(result);
			}
		})
	})
})
</script>
</head>
<body>
   <div class="container">
     <h1 class="text-center">맛집 예약</h1>
     <div class="row">
       <table class="table">
        <tr>
          <td class="danger" width=30% height="700">
            <table class="table">
             <caption><h3>맛집 정보</h3></caption>
             <tr>
              <td>
               <select id="type">
                <option>한식</option>
                <option>양식</option>
                <option>중식</option>
                <option>일식</option>
                <option>기타</option>
               </select>
              </td>
             </tr>
             <tr>
               <td>
                 <div style="overflow-y:scroll; height: 600px" id="food">
                   
                 </div>
               </td>
             </tr>
            </table>
          </td>
          <td class="info" width=40% height="700">
            <table class="table">
             <caption><h3>날짜 정보</h3></caption>
            </table>
          </td>
          <td class="success" width=30% rowspan="2" height="900">
            <table class="table">
             <caption><h3>예약 정보</h3></caption>
             <tr>
               <td>
                 <table class="table">
                  <tr>
                    <td class="text-center">
                      <img src="default.png" style="width: 300px;height: 300px" id="rImg">
                    </td>
                  </tr>
                 </table>
               </td>
             </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td class="warning" height="200">
            <table class="table">
             <caption><h3>시간 정보</h3></caption>
             
            </table>
          </td>
          <td class="default" width=20% height="200">
            <table class="table">
             <caption><h3>인원 정보</h3></caption>
            </table>
          </td>
        </tr>
       </table>
     </div>
   </div>
</body>
</html>







