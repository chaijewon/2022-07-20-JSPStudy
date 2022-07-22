<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<jsp:useBean id="dao" class="com.sist.dao.LocationDAO"/>
<%--  LocationDAO dao=new LocationDAO() --%>
<%
    //1. page 받기
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    int curpage=Integer.parseInt(strPage);
    // 현재 페이지에 대한 데이터 읽기 (DAO)
    List<LocationVO> list=dao.locationListData(curpage);
    // 총페이지 구하기 
    int totalpage=dao.locationTotalPage();
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
   width:960px;
}
</style>
</head>
<body>
  <div class="container">
   <%--
          JSP => View (출력만 담당) 
    --%>
   <div class="row">
     <%
        for(LocationVO vo:list)
        {
     %>
             <div class="col-md-3">
		      <div class="thumbnail">
		        <a href="#">
		          <img src="<%=vo.getPoster() %>" style="width:220px;height: 150px">
		          <div class="caption">
		            <p style="font-size: 9px"><%=vo.getTitle() %></p>
		          </div>
		        </a>
		      </div>
		    </div>
     <%
        }
     %>
   </div>
   <div class="row">
     <div class="text-center">
       <a href="seoul.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-success">이전</a>
        <%= curpage %> page / <%=totalpage %> pages
       <a href="seoul.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-info">다음</a>
     </div>
   </div>
  </div>
</body>
</html>






