<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%= application.getRealPath("/") %>
 <form method=post action="input_ok.jsp" enctype="multipart/form-data">
  <input type=file name=upload size=20>
  <button>전송</button>
 </form>
</body>
</html>