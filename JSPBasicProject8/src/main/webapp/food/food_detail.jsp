<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    String no=request.getParameter("no");
    FoodDAO dao=new FoodDAO();
    FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
    
    String address=vo.getAddress();
    String addr1=address.substring(0,address.lastIndexOf("지"));
    String addr2=address.substring(address.lastIndexOf("번")+1);
    /*
       	서울특별시 영등포구 당산로 180 신우빌딩 1F 지번 서울시 영등포구 당산동4가 31-2 신우빌딩 1F
    */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
<style type="text/css">
.container{
   margin-top: 50px;
   width: 1500px;
}
.header{
   margin: opx auto;
   width:100%;
   height: 200px;
   /* background-color: red; */
}
.section{
   width:65%;
   height: 500px;
   /* background-color: green; */
   float: left;
}
.aside{
   width:35%;
   height: 500px;
   /* background-color: yellow; */
   float: left;
}
.row{
  margin: 0px auto;
  width:1200px;
  text-align: center;
}
</style>
</head>
<body>
  <div class="container">
   <div class="row">
    <div class="header">
     <table class="table_content" width=1100>
       <tr>
         <%
             String poster=vo.getPoster();
             StringTokenizer st=new StringTokenizer(poster,"^");
             while(st.hasMoreTokens())
             {
         %>
                <td align=center>
                 <img src="<%=st.nextToken() %>" width=100%>
                </td>
         <%
             }
         %>
       </tr>
     </table>
    </div>
    <div class="section">
      <table class="table_content" width="700">
        <tr>
         <td colspan="2">
          <h3><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></h3>
         </td>
        </tr>
        <tr>
         <th width=20%>주소</th>
         <td width=80% align=left><%=vo.getAddress() %></td>
        </tr>
        <tr>
         <th width=20%>전화</th>
         <td width=80% align=left><%=vo.getTel() %></td>
        </tr>
        <tr>
         <th width=20%>음식종류</th>
         <td width=80% align=left><%=vo.getType() %></td>
        </tr>
        <tr>
         <th width=20%>가격대</th>
         <td width=80% align=left><%=vo.getPrice() %></td>
        </tr>
        <tr>
         <th width=20%>영업시간</th>
         <td width=80% align=left><%=vo.getTime() %></td>
        </tr>
        <tr>
         <th width=20%>주차</th>
         <td width=80% align=left><%=vo.getParking() %></td>
        </tr>
        <%
           if(!vo.getMenu().equals("no"))
           {
        %>
        <tr>
         <th width=20%>메뉴</th>
         <td width=80% align=left>
           <ul>
             <%
                 st=new StringTokenizer(vo.getMenu(),"원");
                 while(st.hasMoreTokens())
                 {
                     out.println("<li>"+st.nextToken()+"원</li>");
                 }
             %>
           </ul>
         </td>
        </tr>
        <%
           }
        %>
        <tr>
          <td colspan="2" align=right>
           <a href="#">찜하기</a>&nbsp;
           <a href="#">예약</a>&nbsp;
           <a href="food_list.jsp">목록</a>
          </td>
        </tr>
      </table>
    </div>
    <div class="aside">
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
		geocoder.addressSearch('<%=addr1.trim()%>', function(result, status) {
		
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
		            content: '<div style="width:150px;text-align:center;padding:6px 0;"><%=vo.getName()%></div>'
		        });
		        infowindow.open(map, marker);
		
		        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
		        map.setCenter(coords);
		    } 
		});    
		</script>
    </div>
   </div>
  </div>
</body>
</html>