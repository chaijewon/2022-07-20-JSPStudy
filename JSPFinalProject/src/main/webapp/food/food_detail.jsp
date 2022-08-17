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
  <main class="container clear">
    <div class="row">
      <table class="table">
       <tr>
         <%--
            SringTokenizer => c:forTokens
          --%>
         <c:forTokens items="${vo.poster }" delims="^" var="image">
           <td class="text-center"><img src="${image }" style="width:100%"></td>
         </c:forTokens>
       </tr>
      </table>
    </div>
    <div class="one_half first">
      <table class="table">
       <tr>
        <td colspan="2">
         <h4>${vo.name }&nbsp;<span style="color:orange">${vo.score }</span></h4>
        </td>
       </tr>
       <tr>
        <th width=30%>주소</th>
        <td width=70%>${addr1 }<br><sub>지번&nbsp;${addr2 }</sub></td>
       </tr>
       <tr>
        <th width=30%>전화</th>
        <td width=70%>${vo.tel }</td>
       </tr>
       <tr>
        <th width=30%>음식종류</th>
        <td width=70%>${vo.type }</td>
       </tr>
       <tr>
        <th width=30%>가격대</th>
        <td width=70%>${vo.price }</td>
       </tr>
       <tr>
        <th width=30%>주차</th>
        <td width=70%>${vo.parking }</td>
       </tr>
       <tr>
        <th width=30%>영업시간</th>
        <td width=70%>${vo.time }</td>
       </tr>
      <c:if test="${vo.menu!='no' }">
       <tr>
        <th width=30%>메뉴</th>
        <td width=70%>
          <ul>
            <c:forTokens items="${vo.menu }" delims="원" var="m">
             <li>${m }원</li>
            </c:forTokens>
          </ul>
        </td>
       </tr>
      </c:if>
      <tr>
       <td colspan="2" class="text-right">
       <c:if test="${sessionScope.id!=null }">
         <c:choose>
            <c:when test="${likecount==0 }">
	          <a href="#" class="btn btn-sm btn-danger">좋아요(1)</a>
	        </c:when>
	        <c:otherwise>
	          <span class="btn btn-sm btn-default">좋아요(1)</span>
	        </c:otherwise>
         </c:choose>
         <c:choose>
          <c:when test="${jcount==0 }">
           <a href="../food/jjim.do?fno=${vo.fno }" class="btn btn-sm btn-info">찜하기</a>
          </c:when>
        <c:otherwise>
         <span class="btn btn-sm btn-default">찜하기</span>
        </c:otherwise>
       </c:choose>
      </c:if>
        <a href="javascript:history.back()" class="btn btn-sm btn-success">목록</a>
       </td>
      </tr>
      </table>
    </div>
    <div class="one_half">
     <div id="map" style="width:100%;height:350px;"></div>

		<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=b18319530b6d6d62d5c86a8807893413&libraries=services"></script>
		<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption); 
		
		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();
		
		// 주소로 좌표를 검색합니다
		geocoder.addressSearch('${addr1}', function(result, status) {
		
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		
		        // 결과값으로 받은 위치를 마커로 표시합니다
		        var marker = new kakao.maps.Marker({
		            map: map,
		            position: coords
		        });
		
		        // 인포윈도우로 장소에 대한 설명을 표시합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content: '<div style="width:150px;text-align:center;padding:6px 0;">${vo.name}</div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		</script>
    </div>
  </main>
</div>
</body>
</html>