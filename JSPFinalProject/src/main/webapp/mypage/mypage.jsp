<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrapper row3">
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">마이페이지</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <h2 class="sectiontitle">마이페이지</h2>
    <!-- ################################################################################################ -->
    <div class="sidebar one_quarter first"> 
      <!-- ################################################################################################ -->
      <h6>설정 메뉴</h6>
      <nav class="sdb_holder">
        <ul>
          <li><a href="#">개인정보</a>
            <ul>
              <li><a href="../member/join_update.do">회원 수정</a></li>
              <li><a href="../member/join_delete.do">회원 탈퇴</a></li>
            </ul>
          </li>
          <li><a href="#">게시판 활동내역</a></li>
          <li><a href="#">예매 내역</a></li>
          <li><a href="#">장바구니</a></li>
          <li><a href="#">구매 내역</a></li>
          <li><a href="../food/jjim_list.do">찜 내역</a></li>
          
        </ul>
      </nav>
      
    </div>
    <!-- ################################################################################################ --> 
    <!-- ################################################################################################ -->
    <div class="content three_quarter"> 
       <jsp:include page="${mypage_jsp }"></jsp:include>
    </div>
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>