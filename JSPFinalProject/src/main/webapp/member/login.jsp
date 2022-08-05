<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Login</title>
  <link href="https://fonts.googleapis.com/css?family=Asap" rel="stylesheet">
  <link rel="stylesheet" href="./style.css">
  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
  <script type="text/javascript">
  $(function() { // window.onload => mounted(Vue) , componentDidMount(React)
	 $('#logBtn').on("click",function(){
		 let id=$('#id').val();
		 if(id.trim()=="")
		 {
			 $('#id').focus();
			 return;
		 }
		 let pwd=$('#pwd').val();
		 if(pwd.trim()=="")
		 {
			 $('#pwd').focus();
			 return;
		 }
		 // 서버로 전송 (id,pwd)
		 // 한파일에서 ==> 요청 , 응답까지 받아서 처리 (파일 유지)
		 // 한파일에서 전송 ==> 결과값을 받을때 새로운 파일이 다시 생성 (JSP)
		 // axios=> 요청 / 응답 (vue,react) => onepage
		 $.ajax({
			 type:'post',
			 url:'../member/login_ok.do',
			 data:{"id":id,"pwd":pwd},
			 success:function(result)
			 {
				 let res=result.trim();
				 // NOID , NOPWD , OK ==> Model => JSP에 출력시에 읽어 온다 
				 if(res==='NOID')
				 {
					 //id가 없는 경우
					 alert("아이디가 존재하지 않습니다");
					 $('#id').val("")
					 $('#pwd').val("")
					 $('#id').focus();
				 }
				 else if(res==='NOPWD')
				 {
					 //비밀번호가 틀린경우
					 alert("비밀번호가 틀립니다");
					 $('#pwd').val("");
					 $('#pwd').focus();
				 }
				 else
				 {
					 //로그인 
					 location.href="../main/main.do";
				 }
			 }
		 })
	 })
  })
  </script>
</head>
<body>
<!-- partial:index.partial.html -->
<form class="login">
  <input type="text" placeholder="ID" id="id">
  <input type="password" placeholder="Password" id="pwd">
  <input type=button value="로그인" id="logBtn" class="button">
</form>
</body>
</html>
