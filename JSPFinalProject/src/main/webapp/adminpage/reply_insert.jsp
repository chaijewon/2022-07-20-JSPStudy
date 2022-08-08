<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h2 class="sectiontitle">답변하기</h2>
     <form method=post action="../freeboard/insert_ok.do" id="frm">
      <table class="table">
        <tr>
          <th width=20% class="text-right">이름</th>
          <td width=80%>
            <input type=text name=name size=15 class="input-sm" id="name">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">제목</th>
          <td width=80%>
            <input type=text name=subject size=50 class="input-sm" id="subject">
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">내용</th>
          <td width=80%>
            <textarea rows="10" cols="50" name=content id="content"></textarea>
          </td>
        </tr>
        <tr>
          <th width=20% class="text-right">비밀번호</th>
          <td width=80%>
            <input type="password" name=pwd size=10 class="input-sm" id="pwd">
          </td>
        </tr>
        <tr>
          <td colspan="2" class="text-center">
            <input type=button value="글쓰기" class="btn btn-sm btn-success" id="writeBtn">
            <input type=button value="취소" class="btn btn-sm btn-info"
              onclick="javascript:history.back()">
          </td>
        </tr>
      </table>
      </form>
</body>
</html>