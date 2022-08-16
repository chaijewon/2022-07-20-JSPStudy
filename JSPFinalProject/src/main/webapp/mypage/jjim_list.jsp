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
  <h2 class="sectiontitle">찜목록</h2>
    <table class="table">
      <tr>
        <th class="text-center"></th>
        <th class="text-center">업체명</th>
        <th class="text-center">전화</th>
        <th class="text-center"></th>
      </tr>
      <c:forEach var="vo" items="${fList }">
        <tr>
          <td class="text-center">
            <img src="${vo.poster }" style="width: 30px;height: 30px">
          </td>
          <td><a href="../food/food_detail.do?fno=${vo.fno }">${vo.name }</a></td>
          <td>${vo.tel }</td>
          <td class="text-center">
            <a href="../food/jjim_cancel.do?fno=${vo.fno }" class="btn btn-xs btn-primary">취소</a>
          </td>
        </tr>
      </c:forEach>
    </table>
</body>
</html>