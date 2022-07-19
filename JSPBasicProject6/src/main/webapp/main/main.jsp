<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 파일 조정  --%>
<%
     String[] jspList={"","../databoard/list.jsp","../databoard/insert.jsp","../databoard/detail.jsp"};
     String no=request.getParameter("mode");
     if(no==null)
    	 no="1";
     String jsp=jspList[Integer.parseInt(no)];
     // 요청 데이터 => main.jsp
     // 액션 태그 =><jsp:~
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="../databoard/table.css">
</head>
<body>
   <%
     pageContext.include("header.jsp");
   %>
   <div class="container">
     <%
       pageContext.include(jsp);
     %>
   </div>
   <%
     pageContext.include("footer.jsp");
   %>
</body>
</html>