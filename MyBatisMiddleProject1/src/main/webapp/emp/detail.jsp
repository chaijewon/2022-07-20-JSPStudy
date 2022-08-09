<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
     EmpDAO dao=new EmpDAO();
     EmpVO vo=dao.empDeptDetailData(7788);
     request.setAttribute("vo", vo);
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
   width: 350px;
}
</style>
</head>
<body>
  <div class="container">
    <h1 class="text-center">${vo.ename }님의 상세정보</h1>
    <div class="row">
      <ul>
       <li>사번:${vo.empno }</li>
       <li>직위:${vo.job }</li>
       <li>입사일:${vo.hiredate }</li>
       <li>급여:${vo.sal }</li>
       <li>부서:${vo.deptno }</li>
       <li>부서명:${vo.dvo.dname }</li>
       <li>근무지:${vo.getDvo().getLoc() }</li>
      </ul>
    </div>
  </div>
</body>
</html>