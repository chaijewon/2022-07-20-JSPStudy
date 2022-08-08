<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2 class="sectiontitle">게시물 내용보기</h2>
  <table class="table">
       <tr>
         <th width=20% class="text-center">번호</th>
         <td width=30% class="text-center">${vo.no }</td>
         <th width=20% class="text-center">작성일</th>
         <td width=30% class="text-center">${vo.dbday }</td>
       </tr>
       <tr>
         <th width=20% class="text-center">이름</th>
         <td width=30% class="text-center">${vo.name }</td>
         <th width=20% class="text-center">조회수</th>
         <td width=30% class="text-center">${vo.hit }</td>
       </tr>
       <tr>
         <th width=20% class="text-center">제목</th>
         <td colspan="3">${vo.subject }</td>
       </tr>
       <tr>
        <td colspan="4" height="200" valign="top" class="text-left">
          <pre style="white-space: pre-wrap;background-color: white;border:none">${vo.content }</pre>
        </td>
       </tr>
       <tr>
         <td colspan="4" class="text-right">
           <a href="../adminpage/reply_insert.do?no=${vo.no }" class="btn btn-xs btn-danger">답변</a>
           <a href="../adminpage/reply.do" class="btn btn-xs btn-warning">목록</a>
         </td>
       </tr>
       
     </table>
</body>
</html>