<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <div class="row">
    <form method=post action="../member/logout_ok.jsp">
    <table class="table">
      <tr>
        <td width=70%>
          <%= session.getAttribute("name") %> 님
        </td>
      </tr>
      <tr>
        <td width=70%>
          메일 : 2  &nbsp; 쪽지 : 2
        </td>
      </tr>
      <tr>
        <td class="text-center">
          <button class="btn btn-sm btn-danger">로그아웃</button>
        </td>
      </tr>
    </table>
    </form>
  </div>
</body>
</html>