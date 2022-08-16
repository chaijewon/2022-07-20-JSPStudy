<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">

$(function(){
	
	$('#postBtn').click(function(){
		// 우편번호 검색 처리 
		new daum.Postcode({
			oncomplete:function(data)
			{
				$('#post').val(data.zonecode)
				$('#addr1').val(data.address)
			}
		}).open()
	})
	// 유효성 검사 
	/*$('#joinBtn').click(function(){
		
	})*/
	$('#eBtn').click(function(){
		let email=$('#email').val();
		if(email.trim()=="")
		{
			$("#email").focus();
			$('#ePrint').text("이메일을 입력하세요")
			return;
		}
		
		$.ajax({
			type:'post',
			url:'../member/email_check.do',
			data:{"email":email},
			success:function(result)
			{
				let count=parseInt(result.trim());
				if(count==0)
				{
					$('#ePrint').text("사용가능한 이메일입니다");
					$('#email').attr('readonly',true);
				}
				else
				{
					$('#ePrint').text("사용중인 이메일입니다");
					$('#email').val("");
					$('#email').focus();
			    }
			}
		})
	})
	
	$('#tBtn').click(function(){
		let tel=$('#tel2').val();
		if(tel.trim()=="")
		{
			$("#tel2").focus();
			$('#tPrint').text("전화번호를 입력하세요")
			return;
		}
		
		$.ajax({
			type:'post',
			url:'../member/tel_check.do',
			data:{"tel":"010-"+tel},
			success:function(result)
			{
				let count=parseInt(result.trim());
				if(count==0)
				{
					$('#tPrint').text("사용가능한 전화번호입니다");
					$('#tel2').attr('readonly',true);
				}
				else
				{
					$('#tPrint').text("사용중인 전호번호입니다");
					$('#tel2').val("");
					$('#tel2').focus();
			    }
			}
		})
	})
	
	$('#joinBtn').click(function(){
		// 체크(유효성 검사)
		$('#join_frm').submit(); //<input type=submit>
	})
})
</script>

</head>
<body>
   <h2 class="sectiontitle">회원수정</h2>
   <form method="post" action="../member/join_update_ok.do" name="join_frm" id="join_frm">
    <table class="table">
      <tr>
       <th class="text-right" width=15%>아이디</th>
       <td width=85% class="inline">
         <input type=text name=id id="join_id" size=30 class="input-sm" readonly value="${vo.id }">
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>비밀번호</th>
       <td width=85% class="inline">
         <input type=password name=pwd id=join_pwd size=30 class="input-sm">
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>이름</th>
       <td width=85%>
         <input type=text name=name id=name size=30 class="input-sm" value="${vo.name }">
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>성별</th>
       <td width=85% class="inline">
         <input type=radio value="남자" name=sex ${vo.sex=='남자'?"checked":"" }>남자
         <input type=radio value="남자" name=sex ${vo.sex=='여자'?"checked":"" }>여자
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>이메일</th>
       <td width=85% class="inline">
         <input type=text name="email" id=email size=70 class="input-sm" value="${vo.email }">
         <input type=button id="eBtn" class="btn btn-sm btn-success" value="이메일확인">
         &nbsp;<span style="color:blue" id="ePrint"></span>
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>우편번호</th>
       <td width=85% class='inline'>
         <input type=text name=post id=post size=30 class="input-sm" readonly value="${vo.post }">
         <input type=button id="postBtn" value="우편번호찾기"
          class="btn btn-sm btn-danger">
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>주소</th>
       <td width=85%>
         <input type=text name=addr1 id=addr1 size=95 class="input-sm" readonly value="${vo.addr1 }">
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>상세주소</th>
       <td width=85%>
         <input type=text name=addr2 id=addr2 size=95 class="input-sm" value="${vo.addr2 }">
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>전화번호</th>
       <td width=85% class="inline">
         <input type=text name=tel1 id=tel1 size=15 class="input-sm" value="010">
         <input type=text name=tel2 id=tel2 size=30 class="input-sm" value="${vo.tel }">
         <input type=button id="tBtn" class="btn btn-sm btn-info" value="전화확인">
         &nbsp;<span style="color:blue" id="tPrint"></span>
       </td>
      </tr>
      <tr>
       <th class="text-right" width=15%>소개</th>
       <td width=85%>
         <textarea rows="10" cols="100" id="content" name="content">${vo.content }</textarea>
       </td>
      </tr>
      <tr>
        <td colspan="2" class="text-center">
         <input type=button class="btn btn-sm btn-primary" value="회원수정"
           id="joinBtn"
         >
         <input type=button class="btn btn-sm btn-danger" value="취소"
          onclick="javascript:history.back()"
         >
        </td>
      </tr>
    </table>
    </form>
</body>
</html>