<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    String cno=request.getParameter("cno");
    if(cno==null)
    	cno="1";
    
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    int curpage=Integer.parseInt(strPage);
    
    MovieDAO dao=new MovieDAO();
    
    List<MovieVO> list=dao.movieListData(Integer.parseInt(cno), curpage);
    // ${request.getAttribute()} => request.setAttribute()
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 100%;
}
</style>
</head>
<body>
<div class='container-fluid'>
    <div class="row">
     <div class="text-right">
      <a href="list.jsp?cno=1" class="btn btn-sm btn-success">현재 상영 영화</a>
      <a href="list.jsp?cno=2" class="btn btn-sm btn-info">개봉 예정 영화</a>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <%-- for(CategoryVO vo:list) --%>
      <%
          for(MovieVO vo:list)
          {
      %>
        <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="detail.jsp?mno=<%= vo.getMno()%>">
	          <img src="<%=vo.getPoster() %>" alt="Lights" style="width:300px;height: 300px">
	          <div class="caption">
	            <p><%=vo.getTitle() %></p>
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
        <a href="#" class="btn btn-sm btn-info">이전</a>
        <a href="#" class="btn btn-sm btn-warning">다음</a>
      </div>
    </div>
  </div>
</body>
</html>