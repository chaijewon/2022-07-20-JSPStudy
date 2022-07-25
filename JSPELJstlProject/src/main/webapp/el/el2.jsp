<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
      EL => 내장 객체 
      String name="홍길동";
      ${name} ==> 출력이 안된다  <%= name %> 
      ------- 일반 변수 출력이 아니다 
      request.setAttribute("name","홍길동");
      ${name} => 키
       ------ request.getAttribute("name")
      session.setAttribute("id","admin");
      ${sessionScope.id}
      
      ====> request,session에 추가된 값을 출력 ==> 525page 
      ***1. requestScope => request.getAttribute() : request.setAttribute("key",value)
                                                     value출력 : getAttribute("key")
                                                     => ${requestScope.key}
                                                     => ${key} ==> requestScope는 생략이 가능 
      ***2. sessionScope => session.getAttribute() : session.setAttribute("key",value)
                                                     value출력 : getAttribute("key")
                                                     => ${sessionScope.key}
                                                     => ${key} ==> sessionScope는 생략이 가능 
                         *** request,session => 같은 키가 있는 경우에는 request가 우선 순위다 
      3. applicationScope => application.getAttribute()
      4. param  ==> request.getParameter("name")  ==> ${param.name}
      5. paramValue => request.getParameterValues("hobby") ==> ${paramValues.hobby}
      
      *** request,session에 추가된 값을 출력 한다 
      
 --%>
<%
     String name="홍길동";
     // ${} => request,session값을 추가 ==> setAttribute() 
     request.setAttribute("name1", "홍길동");
     session.setAttribute("name2", "심청이");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  이름:${name1 }<br>
  이름:${name2 }<br>
</body>
</html>