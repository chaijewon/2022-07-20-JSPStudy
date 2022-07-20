<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%-- <%= application.getMajorVersion() %><br>
   <%=application.getMinorVersion() %><br>
   <%= application.getServerInfo() %> --%>
   <%-- log() : 서버관리자 --%>
   <%
      // web.xml 등록된 값읽기 
      String driver=application.getInitParameter("driver");//<param-name>driver</param-name>
      String url=application.getInitParameter("url");
      String username=application.getInitParameter("username");
      String password=application.getInitParameter("password");
      application.log("Driver:"+driver);
      application.log("URL:"+url);
      application.log("Username:"+username);
      application.log("Password:"+password);
   %>
   <%= application.getRealPath("/")%>
   
</body>
</html>


