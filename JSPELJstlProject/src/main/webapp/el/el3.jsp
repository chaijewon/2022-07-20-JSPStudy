<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.main.*"%>
<jsp:useBean id="model" class="com.sist.main.Model"/>
<%
     model.getSawonData(request); // Controller
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  사번:  ${sa.getSabun() }<br>
  자바:  <%= ((Sawon)request.getAttribute("sa")).getSabun() %><br>
  이름:  ${sa.getName() }<br>
  자바:  <%= ((Sawon)request.getAttribute("sa")).getName() %><br>
  부서:  ${sa.getDept() }<br>
  자바:  <%= ((Sawon)request.getAttribute("sa")).getDept() %><br>
  <h3>약식</h3>
  사번:  ${sa.sabun}<br><%-- sa.getSabun() --%>
  이름:  ${sa.name }<br>
  부서:  ${sa.dept }<br>
</body>
</html>