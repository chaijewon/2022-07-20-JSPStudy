<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<figure>
				<img src="${vo.poster }">
				<!-- full size image at: https://images.unsplash.com/photo-1560072810-1cffb09faf0f -->
				<figcaption>${vo.name }</figcaption>
			</figure>
			<div>
				<p class="description">
				 ${vo.sub }
				</p>
				<p class="price"><span style="color:orange">${vo.discount}%</span> ${vo.price }</p>
				<p class="price">첫구매할인가:${vo.first_price }</p>
				<div class="form">
					<label for="quantity-select">Quantity:</label>
					<select name="quantity" id="quantity-select">
						<option value=""></option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="1">6</option>
						<option value="2">7</option>
						<option value="3">8</option>
						<option value="4">9</option>
						<option value="5">10</option>
					</select>
					<button type="button">장바구니</button>
					<button type="button">바로구매</button>
				</div>
			</div>
	</div>
</body>
</html>