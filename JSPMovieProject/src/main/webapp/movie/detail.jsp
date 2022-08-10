<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    String mno=request.getParameter("mno");
    MovieDAO dao=new MovieDAO();
    MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
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
   width: 700px;
}
</style>
</head>
<body>
   <div class="container">
     <h3 class="text-center">&lt;<%=vo.getTitle() %>&gt; 상세보기</h3>
     <div class="row">
       <table class="table">
        <tr>
          <td>
           <embed src="http://youtube.com/embed/<%=vo.getKey()%>" style="width:700px;height: 350px">
          </td>
        </tr>
       </table>
     </div>
     <div style="height: 10px"></div>
     <div class="row">
      <table class="table">
       <tr>
         <td width=30% class="text-center" valign="top" rowspan="9">
           <img src="<%=vo.getPoster() %>" style="width: 200px;height: 400px">
         </td>
         <td colspan="2">
           <h3><%=vo.getTitle() %><span style="color:orange"><%=vo.getScore() %></span></h3>
         </td>
       </tr>
       <tr>
         <td width=15%>감독</td>
         <td width=55%><%=vo.getDirector() %></td>
       </tr>
       <tr>
         <td width=15%>출연</td>
         <td width=55%><%=vo.getActor() %></td>
       </tr>
       <tr>
         <td width=15%>장르</td>
         <td width=55%><%=vo.getGenre() %></td>
       </tr>
       <tr>
         <td width=15%>등급</td>
         <td width=55%><%=vo.getGrade() %></td>
       </tr>
       <tr>
         <td width=15%>개봉일</td>
         <td width=55%><%=vo.getRegdate() %></td>
       </tr>
       <tr>
         <td width=15%>관람객</td>
         <td width=55%><%=vo.getShowuser() %></td>
       </tr>
       <tr>
         <td width=15%>상영시간</td>
         <td width=55%><%=vo.getTime() %></td>
       </tr>
       <tr>
         <td width=15%>예매율</td>
         <td width=55%><%=vo.getReserve() %></td>
       </tr>
       <tr>
         <td colspan="3" class="text-right">
           <a href="list.jsp" class="btn btn-sm btn-primary">목록</a>
         </td>
       </tr>
       </table>
       
     </div>
   </div>
</body>
</html>







