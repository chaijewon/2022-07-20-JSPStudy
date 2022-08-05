<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
  <script type="text/javascript">
    $(function() {
        $('#submit-btn').click(function() {
        	
            let password = $('#password').val();
            if (password.trim() == "") {
                $('#password').focus();
                return;
            }
            
            if (confirm("정말 탈퇴하시겠습니까?")) {
            	$.ajax({
                    type : 'post',
                    url : '../mypage/delete_ok.do',
                    data : {"password" : password},
                    success : function(result) {
                        let res = result.trim();
                        if (res == "no") {
                            alert('비밀번호가 일치하지 않습니다.');
                            $('#password').val("");
                            $('#password').focus();
                        } else {
                            alert("회원 탈퇴를 완료했습니다");
                            location.href = "../main/main.do";
                        }
                    }
                })
            }
        })
    })
  </script>
</head>
<body>
  <div class="row border">
    <div class="col-md-12"><h4>&nbsp;&nbsp;<i class="fa fa-user-circle" aria-hidden="true"></i> <b>마이페이지 / 회원 탈퇴</b></h4></div>
  </div>
  <div class="pwd-check roomy-20">
    <div class="row">
      <div class="col-md-12">
        <div><input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요"></div>
        <div><input type="button" id="submit-btn" class="btn btn-primary" value="제출"></div>
      </div>
    </div>
  </div>
</body>
</html>