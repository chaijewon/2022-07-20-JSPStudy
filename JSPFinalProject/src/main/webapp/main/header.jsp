<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">맛집 & 레시피 & 서울여행</a></h1>
    </div>
    <div class="fl_right">
      <ul class="inline">
       <c:if test="${sessionScope.id==null }">
        <li><img src="../main/images/login.png" style="width:50px;height:50px" class="images" id="logImg" title="로그인"></li>
       </c:if>
       <c:if test="${sessionScope.id!=null }">
        <li><img src="../main/images/logout.png" style="width:50px;height:50px" class="images" id="logoutImg" title="로그아웃"></li>
       </c:if>
        <li><img src="../main/images/store2.png" style="width:100px;height:50px" class="images"></li>
      </ul>
    </div>
    <!-- ################################################################################################ --> 
  </header>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <!-- ################################################################################################ -->
    <ul class="clear">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <c:if test="${sessionScope.id==null }">
	      <li><a class="drop" href="#">회원</a>
	        <ul>
	          <li><a href="../member/join.do">회원가입</a></li>
	          <li><a href="pages/full-width.html">아이디찾기</a></li>
	          <li><a href="pages/sidebar-left.html">비밀번호찾기</a></li>
	        </ul>
	      </li>
      </c:if>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../food/food_find.do">지역별 맛집</a></li>
          <c:if test="${sessionScope.id!=null }">
           <li><a href="pages/full-width.html">맛집 추천</a></li>
           <li><a href="../reserve/reserve.do">맛집 예약</a></li>
          </c:if>
        </ul>
      </li>
      <li><a class="drop" href="#">레시피</a>
        <ul>
          <li><a href="../recipe/recipe_list.do">레시피목록</a></li>
          <%--
              DispatcherServlet ==> Model을 찾는다 (@RequestMapping) = 스프링
           --%>
          <li><a href="../recipe/chef_list.do">쉐프</a></li>
          <c:if test="${sessionScope.id!=null }">
            <li><a href="pages/gallery.html">가격비교</a></li>
            <li><a href="pages/sidebar-left.html">레시피만들기</a></li>
          </c:if>
        </ul>
      </li>
      <li><a class="drop" href="#">서울여행</a>
        <ul>
          <li><a href="../seoul/location.do">명소</a></li>
          <%--
             DispatcherServlet  : 요청 (URL주소) 
              | request 
             Model (~VO , ~DAO , ~Model)
              FoodModel 
              SeoulModel --------- View
              
           --%>
          <li><a href="../seoul/nature.do">자연&관광</a></li>
          <li><a href="../seoul/shop.do">쇼핑</a></li>
          <li><a href="../seoul/hotel.do">호텔</a></li>
          <li><a href="../seoul/guest.do">게스트하우스</a></li>
          <c:if test="${sessionScope.id!=null }">
            <li><a href="pages/sidebar-left.html">코스 추천</a></li>
          </c:if>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="../freeboard/list.do">자유게시판</a></li>
          <li><a href="../board_reply/list.do">묻고답하기</a></li>
          <li><a href="pages/sidebar-left.html">공지사항</a></li>
        </ul>
      </li>
      <c:if test="${sessionScope.id!=null }">
       <c:if test="${sessionScope.admin=='n' }">
        <li><a href="../mypage/mypage.do">마이페이지</a></li>
       </c:if>
       <c:if test="${sessionScope.admin=='y' }">
        <li><a href="../adminpage/adminpage.do">어드민페이지</a></li>
       </c:if>
      </c:if>
    </ul>
    <!-- ################################################################################################ --> 
  </nav>
</div>
</body>
</html>