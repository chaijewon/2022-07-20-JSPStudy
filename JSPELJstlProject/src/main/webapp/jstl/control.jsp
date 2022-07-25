<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%--라이브러리 로드 545page--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
    <core:
    <c:
 --%>
<%--
      JSTL : JSP Standard Tag Lib => tag로 자바 제어문을 제공 (XML형식)
      = core : 변수 선언 , 화면 출력 , 제어문 , 화면이동 
        변수 선언 
          <c:set var="" value=""> 
                 ------ --------
                   key   value값 
          예) 
              <c:set var="name" value="박문수"> ==> request.setAttribute("name","박문수")
              Jquery => ${} <c:out value=""> :화면 출력 
              ------ javascript라이브러리 
              
              <c:if> => 단점 (else가 없다)  ==> 사용자 정의 
              --------------------------
              <c:choose> ==> 다중 조건문
                <c:when></c:when>
                <c:otherwise></c:otherwise>
              </c:choose>
              반복문 
              <c:forEach var="i" begin="1" end="10" step="1">
              </c:forEach> => for(int i=1;i<=10;i++)
              
              <c:forEach var="vo" items="list"> => for(SawonVO vo:list)
              
              <c:forTokens>  => StringTokenizer => st.hasTokens
              
              response.sendRedirect() ==> <c:redirect url="">
              <%
                  for()
                  {
                    if()
                    {
              %>
              <%
                    }
                    else if()
                    {
              %>
              <%
                    }
                    else if()
                    {
               %>
               <%
                    }
                    else
                    {
               %>
               <%
                    }
                  }
              %>
              
              <c:forEach>
                <c:choose>
                  <c:when><ul></ul></c:when>
                  <c:when></c:when>
                  <c:when></c:when>
                  <c:otherwise><c:otherwise>
                </c:choose>
              </c:forEach>
      = fmt : 변환 (날짜 변환,숫자변환) 
              <fmt:formatDate> => 오라클  ==> SimpleDateFormat
              <fmt:formatNumber> => 오라클 ==> NumberFormat
      = fn : String =>  메소드 
              ${fn:substring()} , ${fn:trim()} ==> 자바에서 처리 => 자동 완성기 
      -----------------------
      = xml
      = sql ==> DAO
      ----------------------- X
      
      =======> 변경 (JSP가 없다) , HTML자체 출력 
                                ThymeLeaf , Vue , React , Ajax
      =======> 변경 (SQL도 없다) , JPA
--%>
<%
    String name="박문수"; // ${name} => request.setAttribute("name",name);
    request.setAttribute("name", name);
%>
<c:set var="addr" value="서울시 강남구"/>
<%-- request.setAttribute("addr","서울시 강남구") --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
이름:${name }<br>
주석:${addr }<br>
<c:out value="${addr }"/> <%-- Jquery와 충돌  --%>
</body>
</html>












