<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.t {
   width:350px;
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#delBtn').click(function(){
		let pwd=$('#join_pwd').val();
		if(pwd.trim()==="")
		{
			$('#join_pwd').focus();
			return;
		}
		$('#join_frm').submit();
	})
})
</script>
</head>
<body>
<h2 class="sectiontitle">회원수정</h2>
   <form method="post" action="../member/join_delete_ok.do" name="join_frm" id="join_frm">
    <table class="table t">
      <tr>
       <th class="text-center" width=25%>비밀번호</th>
       <td width=75% class="text-center">
         <input type=password name=pwd id="join_pwd" size=30 class="input-sm">
       </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
          <input type=button value="회원탈퇴" class="btn btn-sm btn-primary" id="delBtn">
          <input type=button value="취소" class="btn btn-sm btn-danger"
            onclick="javascript:history.back()">
        </td>
      </tr>
    </table>
   </form>
</body>
</html>