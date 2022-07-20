<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    //1. 데이터받기 => 검색어 , 페이지 
    request.setCharacterEncoding("UTF-8");
    String fd=request.getParameter("fd");
    String strPage=request.getParameter("page");
    
    if(fd==null)
    	fd="역삼";
    if(strPage==null)
    	strPage="1";
    
    // 현재 페이지 
    int curpage=Integer.parseInt(strPage);
    // 결과값 읽기 
    FoodDAO dao=new FoodDAO();
    List<FoodVO> list=dao.foodListData(fd, curpage);
    for(FoodVO vo:list)
    {
    	String poster=vo.getPoster();
    	poster=poster.substring(0,poster.indexOf("^"));
    	vo.setPoster(poster);
    	// 	서울특별시 마포구 연남로1길 11 1F
    	String address=vo.getAddress();
    	String addr1=address.substring(address.indexOf(" "));
    	String addr2=addr1.trim().substring(0,addr1.trim().indexOf(" "));
    	vo.setAddress(addr2);
    }
    int totalpage=dao.foodTotalPage(fd);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.container{
   margin-top: 50px;
   width:100%;
}
.row{
   margin: 0px auto;
   width:800px;
}
.find{
   text-align: center;
}
.food_list{
  width:800px;
  margin: 0px auto;
}
.food{
  width: 250px;
  text-align: center;
  display: block;
  float: left;
}
.food_name{
  margin-top: 5px;
  margin-bottom: 4px;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <div class="find">
        <form method=post action="food_list.jsp">
         Search:<input type=text size=30 name=fd>
         <input type=submit value="검색">
        </form>
       </div>
     </div>
     <div style="height: 30px"></div><!-- 위 아래 간격 -->
     <div class="row">
       <div class="food_list">
       <%
          for(FoodVO vo:list)
          {
       %>
        <a class="food">
          <img src="<%=vo.getPoster() %>" style="width:230px;height: 150px">
          <div class="food_name"><%=vo.getName() %>&nbsp;<span style="color:orange"><%=vo.getScore() %></span></div>
          <div class="food_name"><%=vo.getType() %>-<%=vo.getAddress() %></div>
        </a>
        <%
          }
        %>
       </div>
     </div>
     <div style="clear: both;"></div>
     </div>
     <div style="text-align: center">
       
         <%
            for(int i=1;i<=totalpage;i++)
            {
         %>
               [<a href="food_list.jsp?page=<%=i%>&fd=<%=fd%>"><%=i %></a>]
         <%
            }
         %>
       
     </div>
   
</body>
</html>






