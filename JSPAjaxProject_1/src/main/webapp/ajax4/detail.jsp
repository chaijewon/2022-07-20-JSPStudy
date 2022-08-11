<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    String mno=request.getParameter("mno");
    
    MovieVO vo=MovieDAO.movieDetailData(Integer.parseInt(mno));
    request.setAttribute("vo", vo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row1{
  width:450px;
}
</style>
</head>
<body>
  <div class="row row1">
    <table class="table">
        <tr>
          <td>
           <embed src="http://youtube.com/embed/${vo.getKey()}" style="width:450px;height: 300px">
          </td>
        </tr>
     </table>
  </div>
  <div style="height: 10px"></div>
  <div class="row row1">
    <table class="table">
       <tr>
         <td width=35% class="text-center" valign="top" rowspan="9">
           <img src="${vo.getPoster() }" style="width: 150px;height: 200px">
         </td>
         <td colspan="2">
           <h3>${vo.getTitle() }<span style="color:orange">${vo.getScore() }</span></h3>
         </td>
       </tr>
       <tr>
         <td width=20%>감독</td>
         <td width=45%>${vo.getDirector() }</td>
       </tr>
       <tr>
         <td width=20%>출연</td>
         <td width=45%>${vo.getActor() }</td>
       </tr>
       <tr>
         <td width=20%>장르</td>
         <td width=45%>${vo.getGenre() }</td>
       </tr>
       <tr>
         <td width=20%>등급</td>
         <td width=45%>${vo.getGrade() }</td>
       </tr>
       <tr>
         <td width=20%>개봉일</td>
         <td width=45%>${vo.getRegdate() }</td>
       </tr>
       <tr>
         <td width=20%>관람객</td>
         <td width=45%>${vo.getShowuser() }</td>
       </tr>
       <tr>
         <td width=20%>상영시간</td>
         <td width=45%>${vo.getTime() }</td>
       </tr>
       <tr>
         <td width=20%>예매율</td>
         <td width=45%>${vo.getReserve() }</td>
       </tr>
       </table>
  </div>
</body>
</html>





