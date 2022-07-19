<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <h1>글쓰기</h1>
    <form method=post action="../databoard/insert_ok.jsp" enctype="multipart/form-data">
    <table class="table_content">
      <tr>
        <th width=15%>이름</th>
        <td width=85%>
         <input type=text name=name size=15>
        </td>
      </tr>
      <tr>
        <th width=15%>제목</th>
        <td width=85%>
         <input type=text name=subject size=50>
        </td>
      </tr>
      <tr>
        <th width=15%>내용</th>
        <td width=85%>
         <textarea rows="10" cols="50" name=content></textarea>
        </td>
      </tr>
      <tr>
        <th width=15%>첨부파일</th>
        <td width=85%>
         <input type=file name=upload size=25>
        </td>
      </tr>
      <tr>
        <th width=15%>비밀번호</th>
        <td width=85%>
         <input type=password name=pwd size=10>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center">
         <input type=submit value="글쓰기">
         <input type=button value="취소" onclick="javascript:history.back()">
        </td>
      </tr>
    </table>
    </form>
  </div>
</body>
</html>







