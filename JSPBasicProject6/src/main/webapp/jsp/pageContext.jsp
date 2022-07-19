<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<%--
        String name=request.getParameter("name")
        => String name=pageContext.getRequest().getParameter("name")
        
        다른 파일을 포함하거나 파일 이동이 가능 
        -----------------------------
        파일 이동 
         response ==========> sendRedirect() => request를 초기화
         pageContext =======> forward() => request을 화면 이동과 동시에 전송
         
         <jsp:include> <jsp:forward> 
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
     int a=10/0;
  %>
</body>
</html>