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
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">자유게시판</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <h2 class="sectiontitle">자유게시판</h2>
    <div class="two_third first">
      <table class="table">
        <tr>
          <td>
            <a href="../freeboard/insert.do" class="btn btn-xs btn-danger">새글</a>
          </td>
        </tr>
      </table>
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
          <%--
              adadadaadad (3) ==> reply ==> insert  freeboard=>rcount++
           --%>
          <td width="10%" class="text-center">${vo.no }</td>
          <td width="45%">${vo.subject }
            &nbsp;&nbsp;
            <c:if test="${vo.rcount>0 }">
             (${vo.rcount })
            </c:if>
          </td>
          <td width="15%" class="text-center">${vo.name }</td>
          <td width="20%" class="text-center">${vo.dbday }</td>
          <td width="10%" class="text-center">${vo.hit }</td>
        </tr>
        </c:forEach>
      </table>
    </div>
    <div class="one_third">2/3</div>
   </main>
   
</div>
</div>
</body>
</html>






