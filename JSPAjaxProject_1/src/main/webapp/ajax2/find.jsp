<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
     request.setCharacterEncoding("UTF-8");
     // <form method=post action="find.jsp"> => find.jsp에서 처리
     // <a href="a.jsp?no=1111"> => a.jsp
     String fd=request.getParameter("fd");
     if(fd==null)
    	 fd="비"; //자신JSP에서 처리 => 디폴트 
     
     List<MovieVO> list=MovieDAO.movieFindData(fd);
     // HTML은 출력 , 데이터 읽기 (자바)
     request.setAttribute("list", list);
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
   width: 1200px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#btn').click(function(){
		let fd=$('#fd').val();
		if(fd.trim()==="")
		{
			$('#fd').focus();
			return;
		}
		$('#frm').submit();
	})
})
</script>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="text-center">
       <form method=post action="find.jsp" id="frm">
         Search:<input type=text size=45 class="input-sm" id="fd" name="fd">
         <input type=button value="검색" id="btn">
       </form>
      </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <c:forEach var="vo" items="${list }">
        <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="detail_before.do?mno=${ vo.getMno()}">
	          <img src="${vo.getPoster() }" alt="Lights" style="width:290px;height: 300px">
	          <div class="caption">
	            <p>${vo.getTitle()}</p>
	          </div>
	        </a>
	      </div>
	    </div>
      </c:forEach>
    </div>
  </div>
</body>
</html>







