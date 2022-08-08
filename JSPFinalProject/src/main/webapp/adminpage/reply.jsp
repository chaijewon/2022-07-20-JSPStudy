<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2 class="sectiontitle">묻고 답하기</h2>
  <table class="table">
    <tr>
      <th width="10%" class="text-center">번호</th>
      <th width="45%" class="text-center">제목</th>
      <th width="15%" class="text-center">이름</th>
      <th width="20%" class="text-center">작성일</th>
      <th width="10%" class="text-center">조회수</th>
    </tr>
    <c:forEach var="vo" items="${list }">
       <tr>
	      <td width="10%" class="text-center">${vo.no }</td>
	      <td width="45%"><a href="../adminpage/detail.do?no=${vo.no }">${vo.subject }</a></td>
	      <td width="15%" class="text-center">${vo.name }</td>
	      <td width="20%" class="text-center">
	        <fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd"/>
	      </td>
	      <td width="10%" class="text-center">${vo.hit }</td>
	    </tr>
    </c:forEach>
  </table>
</body>
</html>







