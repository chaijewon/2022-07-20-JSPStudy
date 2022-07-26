<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="model" class="com.sist.model.BoardModel"/>
<%
     model.boardListData(request);
     /*
          request 
          ========
	       request.setAttribute("curpage", curpage);
	   	   request.setAttribute("totalpage", totalpage);
	   	   request.setAttribute("count", count);
	   	   request.setAttribute("list", list);
     */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 850px;
}
body{
   font-size: 9px;
}
</style>
</head>
<body>
   <div class="container">
	   <div class="row">
	       <div class="text-right">
	         <img src="back.png" style="width:250px;height: 150px">
	       </div>
	   </div>
	   <div style="height: 20px"></div>
	   <div class="row">
	    <table class="table">
	      <tr>
	       <td>
	        <a href="insert.jsp" class="btn btn-sm btn-primary">새글</a>
	       </td>
	      </tr>
	    </table>
	    <table class="table table-hover">
	      <tr class="success">
	        <th width=10% class="text-center">번호</th>
	        <th width=45% class="text-center">제목</th>
	        <th width=15% class="text-center">이름</th>
	        <th width=20% class="text-center">작성일</th>
	        <th width=10% class="text-center">조회수</th>
	      </tr>
	      <%--
	           for(ReplyBoardVO vo:list)
	      --%>
	      <c:set var="count" value="${count }"/>
	      <c:forEach var="vo" items="${list }">
	         <tr>
	            <td width=10% class="text-center">${count }</td>
		        <td width=45%>
		         <%-- if(vo.getGroup_tab()>0) --%>
		         <c:if test="${vo.group_tab>0 }">
		           <%-- for(int i=0;i<vo.getGroup_tab();i++) 
		                end ==>  i<=
		           --%>
		           <c:forEach var="i" begin="1" end="${vo.group_tab }" step="1">
		              &nbsp;&nbsp;
		           </c:forEach>
		           <img src="re_icon.gif">
		         </c:if>
		          <c:if test="${vo.subject==msg }">
		            <span style="color:gray">${vo.subject }</span>
		          </c:if>
		          <c:if test="${vo.subject!=msg }">
		            <a href="detail.jsp?no=${vo.no }">${vo.subject }</a>
		          </c:if>
		           &nbsp;
		           <c:if test="${today==vo.dbday }">
		             <sup><img src="new.gif"></sup>
		           </c:if>
		         </td><%-- vo.getSubject() --%>
		        <td width=15% class="text-center">${vo.name }</td>
		        <td width=20% class="text-center">${vo.dbday }</td>
		        <td width=10% class="text-center">${vo.hit }</td>
	         </tr>
	         <c:set var="count" value="${count-1 }"/>
	      </c:forEach>
	    </table>
	   </div>
	   <div class="row">
	     <div class="text-center">
	      <a href="list.jsp?page=${curpage>1?curpage-1:curpage }" class="btn btn-xs btn-success">이전</a>
	        ${curpage } page / ${totalpage } pages
	      <a href="list.jsp?page=${curpage<totalpage?curpage+1:curpage }" class="btn btn-xs btn-success">다음</a>
	     </div>
	   </div>
   </div>
</body>
</html>







