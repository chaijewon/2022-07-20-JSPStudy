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
   <form method=post action="../member/login_ok.jsp">
    <table class="table">
      <tr>
        <th class="text-right" width=30%>ID</th>
        <td width=70%>
          <input type=text name=id size=15 class="input-sm" required>
          <!-- sm md lg xs -->
        </td>
      </tr>
      <tr>
        <th class="text-right" width=30%>PW</th>
        <td width=70%>
          <input type=password name=pwd size=15 class="input-sm" required>
          <!-- sm md lg xs -->
        </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
          <button class="btn btn-sm btn-danger">로그인</button>
        </td>
      </tr>
    </table>
    </form>
  </div>
</body>
</html>