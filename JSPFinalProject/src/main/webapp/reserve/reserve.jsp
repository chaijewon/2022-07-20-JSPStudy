<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
  </main>
</div>
</body>
</html>