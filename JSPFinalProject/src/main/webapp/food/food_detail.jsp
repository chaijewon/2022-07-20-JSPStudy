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
<div class="wrapper row3">
  <main class="container clear">
    <div class="row">
      <table class="table">
       <tr>
         <%--
            SringTokenizer => c:forTokens
          --%>
         <c:forTokens items="${vo.poster }" delims="^" var="image">
           <td class="text-center"><img src="${image }" style="width:100%"></td>
         </c:forTokens>
       </tr>
      </table>
    </div>
    <div class="one_half first">
      <table class="table">
       <tr>
        <td colspan="2">
         <h4>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h4>
        </td>
       </tr>
       <tr>
        <th width=30%>주소</th>
        <td width=70%>${addr1 }<br><sub>지번&nbsp;${addr2 }</sub></td>
       </tr>
       <tr>
        <th width=30%>전화</th>
        <td width=70%>${vo.tel }</td>
       </tr>
       <tr>
        <th width=30%>음식종류</th>
        <td width=70%>${vo.type }</td>
       </tr>
       <tr>
        <th width=30%>가격대</th>
        <td width=70%>${vo.price }</td>
       </tr>
       <tr>
        <th width=30%>주차</th>
        <td width=70%>${vo.parking }</td>
       </tr>
       <tr>
        <th width=30%>영업시간</th>
        <td width=70%>${vo.time }</td>
       </tr>
      <c:if test="${vo.menu!='no' }">
       <tr>
        <th width=30%>메뉴</th>
        <td width=70%>
          <ul>
            <c:forTokens items="${vo.menu }" delims="원" var="m">
             <li>${m }원</li>
            </c:forTokens>
          </ul>
        </td>
       </tr>
      </c:if>
      <tr>
       <td colspan="2" class="text-right">
        <a href="#" class="btn btn-sm btn-danger">좋아요(1)</a>
        <a href="#" class="btn btn-sm btn-info">찜하기</a>
        <a href="javascript:history.back()" class="btn btn-sm btn-success">목록</a>
       </td>
      </tr>
      </table>
    </div>
    <div class="one_half">
     
    </div>
  </main>
</div>
</body>
</html>