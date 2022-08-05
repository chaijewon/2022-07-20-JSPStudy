<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <div class="text-center"><h3>마이페이지</h3></div>
  <div class="menu">
    <ul>
      <li id="<c:if test="${tab==1 }">selected</c:if>"><a href="../mypage/mypage.do">내 정보</a></li>
      <li id="<c:if test="${tab==2 }">selected</c:if>"><a href="../mypage/update.do">개인정보 수정</a> </li>
      <li id="<c:if test="${tab==3 }">selected</c:if>"><a href="../mypage/update_pwd.do">비밀번호 변경</a></li> 
      <li id="<c:if test="${tab==4 }">selected</c:if>"><a href="../mypage/delete.do">회원 탈퇴</a></li>
      <li id="<c:if test="${tab==5 }">selected</c:if>"><a href="../mypage/favorite.do">즐겨찾기 관리</a></li>
    </ul>
  </div>
</body>
</html>