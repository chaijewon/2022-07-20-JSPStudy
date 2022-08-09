<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="model" class="com.sist.model.EmpModel"/>
<%
    model.empListData(request);
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
   width: 960px;
}
</style>
</head>
<body>
 <div class="container">
    <h1 class="text-center">사원 목록</h1>
    <div class="row">
      <table class="table table-hover">
       <tr class="danger">
         <th class="text-center">사번</th>
         <th class="text-center">이름</th>
         <th class="text-center">직위</th>
         <th class="text-center">사수번호</th>
         <th class="text-center">입사일</th>
         <th class="text-center">급여</th>
         <th class="text-center">성과급</th>
         <th class="text-center">부서번호</th>
       </tr>
       <%-- for(EmpVO vo:list) --%>
       <c:forEach var="vo" items="${list }">
         <tr>
          <td class="text-center">${vo.empno }</td>
          <td class="text-center">${vo.ename }</td>
          <td class="text-center">${vo.job }</td>
          <td class="text-center">${vo.mgr }</td>
          <td class="text-center">${vo.hiredate }</td>
          <td class="text-center">${vo.sal }</td>
          <td class="text-center">${vo.comm }</td>
          <td class="text-center">${vo.deptno }</td>
         </tr>
       </c:forEach>
     </table>
  </div>
 </div>
</body>
</html>