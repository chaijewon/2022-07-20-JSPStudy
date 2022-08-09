<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*,java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
     EmpDAO dao=new EmpDAO();
     List<String> list=dao.empGetEnameData();
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
   width: 300px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
     <form method=post action="find_ok.jsp">
      <c:forEach var="name" items="${list }">
       <input type="checkbox" name="names" value="${name }">${name }
      </c:forEach>
      <br>
      <input type=submit value="전송" class="btn btn-sm btn-primary">
      </form>
    </div>
    
  </div>
</body>
</html>






