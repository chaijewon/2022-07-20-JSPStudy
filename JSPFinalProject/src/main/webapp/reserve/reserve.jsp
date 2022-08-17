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
		type:'post',
		url:'../reserve/food_list.do', // Model
		success:function(result)
		{
			$('#food').html(result);
		}
	})
	$('#f_name_lab').hide();
	$('#type').change(function(){
		let type=$('#type').val();
		$.ajax({
			type:'post',
			url:'../reserve/food_list.do', // Model
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
<div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">맛집</a></li>
      <li><a href="#">맛집예약</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <h2 class="sectiontitle">맛집예약</h2>
    <div class="row">
       <table class="table">
        <tr>
          <td class="danger" width=30% height="600">
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
                 <div style="overflow-y:scroll; height: 500px" id="food">
                   
                 </div>
               </td>
             </tr>
            </table>
          </td>
          <td class="info" width=40% height="600">
            <table class="table">
             <caption><h3>날짜 정보</h3></caption>
             <tr>
               <td class="text-center" id="r_date"></td>
             </tr>
            </table>
          </td>
          <td class="success" width=30% rowspan="2" height="800">
            <table class="table">
             <caption><h3>예약 정보</h3></caption>
             <tr>
               <td>
                 <table class="table">
                  <tr>
                    <td class="text-center" colspan="2">
                      <img src="default.png" style="width: 300px;height: 300px" id="rImg">
                    </td>
                  </tr>
                  <tr>
                    <td id="f_name_lab" width="30%">상호명</td>
                    <td id="f_name" width="70%"></td>
                  </tr>
                 </table>
               </td>
             </tr>
            </table>
          </td>
        </tr>
        <tr>
          <td class="warning" height="100">
            <table class="table">
             <caption><h3>시간 정보</h3></caption>
             
            </table>
          </td>
          <td class="default" width=20% height="100">
            <table class="table">
             <caption><h3>인원 정보</h3></caption>
            </table>
          </td>
        </tr>
       </table>
     </div>
  </main>
</div>
</body>
</html>