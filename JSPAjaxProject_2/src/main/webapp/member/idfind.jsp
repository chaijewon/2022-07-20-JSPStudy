<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 600px;
}
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script type="text/javascript">
$(function(){
	$('#tabs').tabs()
	$('#idBtn1').click(function(){
		let name=$('#email_name').val();
		if(name.trim()==="")
		{
			$('#email_name').focus();
			$('#id_result1').text("이름을 입력하세요")
			return;
		}
		let email=$('#email').val();
		if(email.trim()==="")
		{
			$('#email').focus();
			$('#id_result1').text("이메일을 입력하세요")
			return;
		}
		
		$.ajax({
			type:'post',
			url:'idfind_ok.jsp',
			data:{"name":name,"email":email}, //idfind_ok.jsp로 결과값 출력 
			success:function(result) // 결과값을 받는다 
			{
				$('#id_result1').text(result);
			}
		})
	}) // email로 찾기 버튼 클릭 
	/*
	     태그에 있는 값읽기 
	     태그.val() ===> input,select,textarea  (사용자 입력값을 읽을때)
	     태그.text()
	       <td>데이터</td> => 태그와 태그사이값을 읽을 경우에 
	     태그.html()
	       <td><a href="">데이터</a></td> ==> $('td').text() ==> 데이터
	                                        $('td').html() ==> <a href="">데이터</a>
	     태그.attr() <img src="데이터"> => $('img').attr("src") ==> 태그의 속성값
	*/
	$('#idBtn2').on('click',function(){
		//1. 이름 입력여부 
		let name=$('#tel_name').val();
		if(name.trim()==="") //!==  ES6
		{
			$('#tel_name').focus();
			$('#id_result2').text("이름을 입력하세요");
			return; // 종료
		}
		//2. 전화번호 입력 여부 
		let tel=$('#tel').val();
		if(tel.trim()==="")
		{
			$('#tel').focus()
			$('#id_result2').text("전화번호를 입력하세요");
			return;
		}
		//3. ajax => 이름 => 전화번호 전송 ====> 결과값을 출력 ==> axios.get() , axios.post()
		$.ajax({
			type:'post',
			url:'telfind_ok.jsp',
			data:{"name":name,"tel":tel},//?tel=1111
			success:function(result)
			{
				$('#id_result2').text(result);
			}
		})
		//4. 출력된 결과값을 읽어 온다 
	})
})
</script>
</head>
<body>
   <div class="container">
     <h1 class="text-center">아이디 찾기</h1>
     <div class="row">
       <div id="tabs">
		  <ul>
		    <li><a href="#tabs-1">이메일로 찾기</a></li>
		    <li><a href="#tabs-2">전화번호로 찾기</a></li>
		  </ul>
		  <div id="tabs-1">
		    <table class="table">
		     <tr>
		      <th width=30% class="text-center">이름</th>
		      <td width=70%>
		        <input type=text id="email_name" class="input-sm" size=20>
		      </td>
		     </tr>
		     <tr>
		      <th width=30% class="text-center">email</th>
		      <td width=70%>
		        <input type=text id="email" class="input-sm" size=35>
		      </td>
		     </tr>
		     <tr>
		      <td colspan="2" class="text-center">
		        <input type=button value="아이디 찾기" class="btn btn-sm btn-primary" id="idBtn1"> 
		      </td>
		     </tr>
		     <tr>
		      <td colspan="2" class="text-center">
		        <h3 id="id_result1"></h3>
		      </td>
		     </tr>
		    </table>
		  </div>
		  <div id="tabs-2">
		    <table class="table">
		     <tr>
		      <th width=30% class="text-center">이름</th>
		      <td width=70%>
		        <input type=text id="tel_name" class="input-sm" size=20>
		      </td>
		     </tr>
		     <tr>
		      <th width=30% class="text-center">전화번호</th>
		      <td width=70%>
		        <input type=text id="tel" class="input-sm" size=35>
		      </td>
		     </tr>
		     <tr>
		      <td colspan="2" class="text-center">
		        <input type=button value="아이디 찾기" class="btn btn-sm btn-primary" id="idBtn2"> 
		      </td>
		     </tr>
		     <tr>
		      <td colspan="2" class="text-center">
		        <h3 id="id_result2" style="color:red"></h3>
		      </td>
		     </tr>
		    </table>
		  </div>
		  
		</div>
     </div>
   </div>
</body>
</html>