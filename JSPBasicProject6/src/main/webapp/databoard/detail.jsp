<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%
    String no=request.getParameter("no");
    DataBoardDAO dao=new DataBoardDAO();
    DataBoardVO vo=dao.databoardDetail(Integer.parseInt(no));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
   width:100%;
   margin-top: 50px;
}
h1{
   text-align: center
}
.table_content{
   margin: 0px auto;
   width:500px;
}
a{
   text-decoration: none;
   color:balck;
}
a:hover{
   text-decoration: underline;
   color:green;
}
</style>
</head>
<body>
  <div class="container">
    <h1>상세보기</h1>
    <table class="table_content">
      <tr>
        <th width=20%>번호</th>
        <td width=30% align=center><%=vo.getNo() %></td>
        <th width=20%>작성일</th>
        <td width=30% align=center><%=vo.getRegdate().toString() %></td>
      </tr>
      <tr>
        <th width=20%>이름</th>
        <td width=30% align=center><%=vo.getName() %></td>
        <th width=20%>조회수</th>
        <td width=30% align=center><%=vo.getHit() %></td>
      </tr>
      <tr>
        <th width=20%>제목</th>
        <td colspan="3"><%=vo.getSubject() %></td>
      </tr>
      
	  <%
	      if(vo.getFilesize()>0)
	      {
	  %>
      <tr>
        <th width=20%>첨부파일</th>
        <td colspan="3"><a href="../databoard/download.jsp?fn=<%=vo.getFilename() %>"><%=vo.getFilename() %></a>(<%=vo.getFilesize() %>Bytes)</td>
      </tr>
      <%
        }
      %>
      <tr>
        <td colspan="4" valign="top" align="left" height="200"><%=vo.getContent() %></td>
      </tr>
      <tr>
        <td colspan="4" align=right>
          <a href="#">수정</a>&nbsp;
          <a href="#">삭제</a>&nbsp;
          <a href="../main/main.jsp?mode=1">목록</a>
        </td>
      </tr>
    </table>
   </div>
</body>
</html>












