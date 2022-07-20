<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
   application 객체 
      => 클래스명 (ServletContext)
      => 서버 정보 (서버명 , 버전명, 로그파일 , 실제경로)
                                       -------
      1. web.xml => 등록된 데이터 읽기 (getInitParameter())
      2.         => log
      3. getRealPath()
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>application : ServletContext => 접속횟수(프로젝트에 있는 모든 JSP에서 접근이 가능)</h1>
  
</body>
</html>








