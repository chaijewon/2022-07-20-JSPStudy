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
<div class="body">
	<div class="hero">
	
		<h2>SIST Store</h2>
		<p class="category-description">SIST Store는 온라인 전용 물류센터 해당하는 수도권에서 운영하던 신선식품 품질보증 서비스 ‘신선보장제도’를 상품에 확대 적용한다</p>
	</div>
	<div style="height: 20px"></div>
	<h1>베스트상품</h1>
		<div class="items">
		  <c:forEach var="vo" items="${bList }">
			<div class="item">
				<figure>
					<div class="img">
						<img src="${vo.poster }">
					</div>
					<figcaption>${vo.name }</figcaption>
					<h3></h3>
					<p class="price">${vo.price }</p>
					<!-- <p class="special">Free Shipping!</p> -->
				</figure>
			</div>
		</c:forEach>
	   </div>
    <div style="height: 20px"></div>
	<h1>신상품</h1>
	   <div class="items">
	   <c:forEach var="vo" items="${nList }">
			<div class="item">
				<figure>
					<div class="img">
						<img src="${vo.poster }">
					</div>
					<figcaption>${vo.name }</figcaption>
					<h3></h3>
					<p class="price">${vo.price }</p>
				</figure>
			</div>
		</c:forEach>
	  </div>
	<div style="height: 20px"></div>
	<h1>특가상품</h1>	
	  <div class="items">
	   <c:forEach var="vo" items="${sList }">
		<div class="item">
			<figure>
				<div class="img">
					<img src="${vo.poster }">
				</div>
				<figcaption>${vo.name }</figcaption>
				<h3></h3>
				<p class="price">${vo.price }</p>
				<!-- <p class="special">Just One Left!</p> -->
			</figure>
		</div>	
	 </c:forEach>
	</div>
</div>
</body>
</html>