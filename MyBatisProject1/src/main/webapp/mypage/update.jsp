<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
  <script type="text/javascript" src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
  <script type="text/javascript">
  
    Shadowbox.init({
        players:['iframe'],
        overlayOpacity: 0.5
    })
    
    $(function(){
        let question = $('#uquestion').val();
        $('#question').val(question).prop("selected", true);
        
        $('#email-check-btn').click(function() {
            Shadowbox.open({
                content:'../users/emailcheck.do',
                player:'iframe',
                width:350,
                height:270
            })
        })
        
        $('#post-btn').click(function() {
            new daum.Postcode({
                oncomplete:function(data) {
                    $('#post').val(data.zonecode);
                    $('#address1').val(data.address);
                }
            }).open()
        })
        
        $('#update-btn').click(function() {
            
            let password = $('#password').val()
            if(password.trim() == "") {
                $('#password').focus();
                return;
            }
            
            let password2 = $('#password2').val()
            if(password2.trim() == "") {
                $('#password2').focus();
                return;
            }
            
            if(password2 != password)  {
                alert("재입력된 비밀번호와 일치하지 않습니다.");
                $('#password2').focus();
                return;
            }
            
            let email = $('#email').val()
            if(email.trim() == "") {
                alert("이메일을 입력하세요");
                return;
            }
            
            let post = $('#post').val()
            if(post.trim() == "") {
                alert("우편번호를 검색하세요");
                return;
            }
                        
            let answer = $('#answer').val()
            if(answer.trim() == "") {
            	$('#answer').focus();
                alert("비밀번호 찾기 답변을 입력하세요");
                return;
            }
            
            if (confirm("해당 정보로 변경하시겠습니까?")) {
                $.ajax({
                    type : 'post',
                    url : '../mypage/update_ok.do',
                    data : $('#user_form').serialize(),
                    success : function(result) {
                        let res = result.trim();
                        if (res == "no") {
                            alert('비밀번호가 일치하지 않습니다.');
                            $('#password').val("");
                            $('#password').focus();
                        } else {
                            alert("회원님의 정보를 수정하였습니다");
                            location.href = "../mypage/mypage.do";
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
    <div class="col-md-12"><h4>&nbsp;&nbsp;<i class="fa fa-user-circle" aria-hidden="true"></i> <b>마이페이지 / 개인정보 수정</b></h4></div>
  </div>
  <div class="update roomy-20">
    <!--   폼   -->
    <form id="user_form">
      <!--   아이디   -->
      <div class="row roomy-10">
        <div class="col-md-12">
          <div>아이디</div>
          <div><input type="text" name="id" id="id" value="${user.u_id }" readonly></div>
        </div>
      </div>
      <!-- -------- -->
      <!--   비밀번호 확인  -->
      <div class="row roomy-10">
        <div class="col-md-12">
          <div>비밀번호 확인</div>
          <div><input type="password" name="password" id="password" placeholder="비밀번호를 입력하세요"></div>
          <div><input type="password" id="password2" placeholder="비밀번호를 재입력하세요"></div>
        <small> 8~20자 사이 및 영문+숫자</small>
        </div>
      </div>
      <!-- -------- -->
      
      <!--   이메일   -->
      <div class="row roomy-10">
        <div class="col-md-12">
          <div>이메일</div>
          <input type="text" name="email" id="email" value="${user.u_email }" placeholder="이메일 주소 중복 확인을 해주세요" readonly>
          <input type="button" id="email-check-btn" value="중복 확인">
        </div>
      </div>
      <!-- -------- -->
                    
      <!--   주소   -->
      <div class="row roomy-10">
        <div class="col-md-12">
          <div>우편번호</div>
          <input type="text" name="post" id="post" value="${user.u_post }"placeholder="우편번호 찾기를 해주세요" readonly>
          <input type="button" id="post-btn" value="우편번호 찾기">
          <div>주소</div>
          <input type="text" name="address1" id="address1" value="${user.u_address1 }" readonly>
          <div>상세주소</div>
          <input type="text" name="address2" id="address2" value="${user.u_address2 }">
        </div>
      </div>
      <!-- -------- -->
      
      <!-- 비밀번호 찾기 질문 답변 -->
      <div class="row roomy-10">
         <div class="col-md-12">
          <div>비밀번호 찾기 질문/답변</div>
          <input type="hidden" value="${user.u_question }" id="uquestion">
          <select name=question id="question">
            <option value="기억에 남는 추억의 장소는?" >기억에 남는 추억의 장소는?</option>
            <option value="자신의 인생 좌우명은?" >자신의 인생 좌우명은?</option>
            <option value="자신의 보물 제1호는?" >자신의 보물 제1호는?</option>
            <option value="가장 기억에 남는 선생님 성함은?" >가장 기억에 남는 선생님 성함은?</option>
            <option value="타인이 모르는 자신만의 신체비밀이 있다면?" >타인이 모르는 자신만의 신체비밀이 있다면?</option>
            <option value="추억하고 싶은 날짜가 있다면?" >추억하고 싶은 날짜가 있다면? </option>
            <option value="받았던 선물 중 기억에 남는 독특한 선물은?" >받았던 선물 중 기억에 남는 독특한 선물은?</option>
            <option value="유년시절 가장 생각나는 친구 이름은?" >유년시절 가장 생각나는 친구 이름은?</option>
            <option value="인상 깊게 읽은 책 이름은?" >인상 깊게 읽은 책 이름은? </option>
            <option value="읽은 책 중에서 좋아하는 구절이 있다면?" >읽은 책 중에서 좋아하는 구절이 있다면?</option>
            <option value="자신이 두번째로 존경하는 인물은?" >자신이 두번째로 존경하는 인물은?</option>
            <option value="친구들에게 공개하지 않은 어릴 적 별명이 있다면?" >친구들에게 공개하지 않은 어릴 적 별명이 있다면?</option>
            <option value="초등학교 때 기억에 남는 짝꿍 이름은?" >초등학교 때 기억에 남는 짝꿍 이름은?</option>
            <option value="다시 태어나면 되고 싶은 것은?" >다시 태어나면 되고 싶은 것은?</option>
            <option value="내가 좋아하는 캐릭터는?" >내가 좋아하는 캐릭터는? </option>
          </select>
          <input type="text" name=answer id=answer value="${user.u_answer }" placeholder="답변을 입력하세요.">
        </div>
      </div>
      <!-- -------- -->
      
      <!--  회원가입 버튼   -->
      <div class="row roomy-10">
        <div class="col-md-12">
          <input type="button" id="update-btn" class="btn btn-primary" value="정보 수정">
          <a href="../mypage/mypage.do" id="cancel-btn" class="btn btn-default">취소</a>
        </div>
      </div>
      <!-- -------- -->
    </form>
    <!-- -------- -->
  </div>
</body>
</html>
