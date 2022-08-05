<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>
<body>
  <div class="row border">
    <div class="col-md-12"><h3>&nbsp;&nbsp;<i class="fa fa-user-circle" aria-hidden="true"></i> <b>마이페이지 / 내 정보</b></h3></div>
  </div>
  <div class="info">
    <div class="row roomy-20">
      <div class="col-md-12"><h4><b>${user.u_name }님 안녕하세요!</b><i class="fa fa-heart" aria-hidden="true"></i></h4></div>
    </div>
    <div class="row roomy-10">
      <div class="col-sm-3"><b>아이디</b></div>
      <div class="col-sm-9">${user.u_id }</div>
    </div>
        <div class="row roomy-10">
      <div class="col-sm-3"><b>이름</b></div>
      <div class="col-sm-9">${user.u_name }</div>
    </div>
    <div class="row roomy-10">
      <div class="col-sm-3"><b>성별</b></div>
      <div class="col-sm-9">${user.u_gender }</div>
    </div>
     <div class="row roomy-10">
      <div class="col-sm-3"><b>이메일</b></div>
      <div class="col-sm-9">${user.u_email }</div>
    </div>
    <div class="row roomy-10">
      <div class="col-sm-3"><b>주소</b></div>
      <div class="col-sm-9">
        <div>${user.u_address1 } ${user.u_address2 } (${user.u_post })</div>
      </div>
    </div>
    <div class="row roomy-10">
      <div class="col-sm-3"><b>비밀번호 찾기 질문</b></div>
      <div class="col-sm-9">
        <div>${user.u_question }</div>
      </div>
    </div>
    <div class="row roomy-10">
      <div class="col-sm-3"><b>비밀번호 찾기 답변</b></div>
      <div class="col-sm-9">
        <div>${user.u_answer }</div>
      </div>
    </div>
  </div>
</body>
</html>