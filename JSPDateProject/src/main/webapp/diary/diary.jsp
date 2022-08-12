<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   width: 600px;
}
</style>
</head>
<body>
  <div class="container">
    <h1 class="text-center">${year }년 ${month }월 ${day }일</h1>
    <div class="row">
      <table class="table">
        <tr>
          <td>
            <select name="year" class="input-sm">
              <c:forEach var="i" begin="2022" end="2030">
               <option ${year==i?"selected":"" }>${i }</option>
              </c:forEach>
            </select>년도&nbsp;
            <select name="month" class="input-sm">
              <c:forEach var="i" begin="1" end="12">
               <option ${month==i?"selected":"" }>${i }</option>
              </c:forEach>
            </select>월&nbsp;
            <input type=button value="선택" id="dateBtn" class="btn btn-sm btn-primary">
          </td>
        </tr>
      </table>
      <div style="height: 15px"></div>
      <table class="table">
        <tr class="success">
          <c:forEach var="sw" items="${strWeek }" varStatus="s">
            <c:choose>
             <c:when test="${s.index==0 }">
              <c:set var="color" value="red"/>
             </c:when>
             <c:when test="${s.index==6 }">
              <c:set var="color" value="blue"/>
             </c:when>
             <c:otherwise>
              <c:set var="color" value="black"/>
             </c:otherwise>
            </c:choose>
            
            <th class="text-center"><h3 style="color:${color}">${sw }</h3></th>
          </c:forEach>
        </tr>
        <c:forEach var="i" begin="1" end="${lastday }">
          <c:if test="${i==1 }">
            <tr style="height: 70px">
            <c:forEach var="j" begin="1" end="${week }">
              <td>&nbsp;</td>
            </c:forEach>
            <%-- 요일만큼 공백 --%>
          </c:if>
          
           <td class="text-center ${i==day?'danger':'' }">${i }</td><%--1일부터 출력 --%>
         
          <c:set var="week" value="${week+1 }"/>
          <c:if test="${week>6 }"><%-- 일요일 다음에 출력  --%>
            </tr>
            <c:set var="week" value="0"/>
            <tr style="height: 70px">
          </c:if>
        </c:forEach>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>








