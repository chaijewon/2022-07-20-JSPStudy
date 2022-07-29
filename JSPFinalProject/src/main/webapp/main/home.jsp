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
<div class="wrapper row3">
  <div id="slider" class="clear"> 
    <!-- ################################################################################################ -->
    <div class="flexslider basicslider">
      <ul class="slides">
        <li><a href="#"><img class="radius-10" src="https://korean.visitseoul.net/comm/getImage?srvcId=CTGRY&parentSn=12&fileTy=IMG&fileNo=1" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="https://korean.visitseoul.net/comm/getImage?srvcId=CTGRY&parentSn=13&fileTy=IMG&fileNo=5" style="width:978px;height:400px"></a></li>
        <li><a href="#"><img class="radius-10" src="https://korean.visitseoul.net/comm/getImage?srvcId=CTGRY&parentSn=16&fileTy=IMG&fileNo=5" style="width:978px;height:400px"></a></li>
      </ul>
    </div>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <!-- ################################################################################################ -->
    <ul class="nospace group btmspace-80">
      <li class="one_third first">
        <article class="service"><i class="icon fa fa-ambulance"></i>
          <h6 class="heading"><a href="#">오늘의 뉴스</a></h6>
          <p>'세계 최초' 3나노 양산에 수익 개선, 美 지원법까지 메모리 '다운사이클'에도 파운드리 호조로 '위안'</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-umbrella"></i>
          <h6 class="heading"><a href="#">오늘의 날씨</a></h6>
          <p>체감온도 35도 육박…무더위 이어져 중부지방 중심 폭염특보 강화 가능성 오후부터 경기북부 등 소나기 소식도</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
      <li class="one_third">
        <article class="service"><i class="icon fa fa-camera-retro"></i>
          <h6 class="heading"><a href="#">이벤트</a></h6>
          <p>취향저격! 나에게 딱 맞는 등산코스는?</p>
          <footer><a href="#">Read More &raquo;</a></footer>
        </article>
      </li>
    </ul>
    <!-- ################################################################################################ -->
    <h2 class="sectiontitle">믿고 보는 맛집 리스트</h2>
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <c:forEach var="vo" items="${list }" varStatus="s">
         <c:if test="${s.index>=0 && s.index<12 }">
	          <li>
		          <figure><img class="radius-10 btmspace-10" src="${vo.poster }" title="${vo.subject }">
		            <figcaption><a href="#">${vo.title }</a></figcaption>
		          </figure>
	          </li>
          </c:if>
        </c:forEach>
      </ul>
    </div>
    <h2 class="sectiontitle">지역별 인기 맛집 리스트</h2>
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <c:forEach var="vo" items="${list }" varStatus="s">
         <c:if test="${s.index>=12 && s.index<18 }">
	          <li>
		          <figure><img class="radius-10 btmspace-10" src="${vo.poster }" title="${vo.subject }">
		            <figcaption><a href="#">${vo.title }</a></figcaption>
		          </figure>
	          </li>
          </c:if>
        </c:forEach>
      </ul>
    </div>
    <h2 class="sectiontitle">메뉴별 인기 맛집 리스트</h2>
    <!-- ################################################################################################ -->
    <div class="flexslider carousel basiccarousel btmspace-80">
      <ul class="slides">
        <c:forEach var="vo" items="${list }" varStatus="s">
         <c:if test="${s.index>=18 && s.index<30 }">
	          <li>
		          <figure><img class="radius-10 btmspace-10" src="${vo.poster }" title="${vo.subject }">
		            <figcaption><a href="#">${vo.title }</a></figcaption>
		          </figure>
	          </li>
          </c:if>
        </c:forEach>
      </ul>
    </div>
    <!-- ################################################################################################ -->
    <h2 class="sectiontitle">최신 방문 맛집</h2>
    <!-- ################################################################################################ -->
    <ul class="nospace group">
      <li class="one_half first">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
      <li class="one_half">
        <article><img class="imgl radius-10" src="../images/demo/100x100.gif" alt="">
          <h6 class="heading"><a href="#">Lorem Ipsum Dolor</a></h6>
          <p>Aenean semper elementum tellus, ut placerat leo. Quisque vehicula, urna sit amet.</p>
        </article>
      </li>
    </ul>
    <!-- ################################################################################################ --> 
    <!-- / main body -->
    <div class="clear"></div>
  </main>
</div>
</body>
</html>