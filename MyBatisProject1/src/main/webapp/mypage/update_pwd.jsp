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
            
            let new_password = $('#new_password').val();
            if (new_password.trim() == "") {
                $('#new_password').focus();
                return;
            }
            
            let new_password2 = $('#new_password2').val();
            if(new_password != new_password2)  {
                alert("비밀번호가 일치하지 않습니다.");
                $('#new_password2').focus();
                return;
            }
            
            if(validatePassword(new_password) == false) {
                return;
            }
            
            if (confirm("해당 정보로 변경하시겠습니까?")) {
            	$.ajax({
                    type : 'post',
                    url : '../mypage/update_pwd_ok.do',
                    data : $('#update_pwd_form').serialize(),
                    success : function(result) {
                        let res = result.trim();
                        if (res == "no") {
                            alert('비밀번호가 일치하지 않습니다.');
                            $('#password').val("");
                            $('#password').focus();
                        } else {
                            alert("비밀번호를 변경했습니다");
                            location.href = "../mypage/mypage.do";
                        }
                    }
                })
            }
        })
    })
    
    function validatePassword(password){
        var num = password.search(/[0-9]/g);
        var eng = password.search(/[a-z]/ig);
        
        if(password.length < 8 || password.length > 20){
            alert("비밀번호를 8자리 ~ 20자리 이내로 입력해주세요.");
            return false;
        } else if(password.search(/\s/) != -1){
            alert("비밀번호는 공백 없이 입력해주세요.");
            return false;
        } else if(num < 0 || eng < 0){
            alert("비밀번호는 영문,숫자를 혼합하여 입력해주세요.");
            return false;
        } else {
            return true;
        }
    }
  </script>
</head>
<body>
  <div class="row border">
    <div class="col-md-12"><h4>&nbsp;&nbsp;<i class="fa fa-user-circle" aria-hidden="true"></i> <b>마이페이지 / 비밀번호 변경</b></h4></div>
  </div>
  <div class="pwd-check roomy-20">
    <form id="update_pwd_form">
      <div class="row roomy-10">
        <div class="col-md-12">
          <div>기존 비밀번호</div>
          <div><input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요"></div>
        </div>
      </div>
      <div class="row roomy-10">
        <div class="col-md-12">
          <div>새 비밀번호</div>
          <div><input type="password" name="new_password" id="new_password" placeholder="새 비밀번호를 입력하세요"></div>
          <div><input type="password" id="new_password2" placeholder="새 비밀번호를 재입력하세요"></div>
          <div><input type="button" id="submit-btn" class="btn btn-primary" value="제출"></div>
        </div>
      </div>
    </form>
  </div>
</body>
</html>