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
    
    List<FoodVO> cList=new ArrayList<FoodVO>();
    // 쿠키 
    Cookie[] cookies=request.getCookies();
    /*
       1. 생성 부분
          new Cookie(키,값); => 값 9문자열로만 저장이 가능
          setPath(): 쿠키 저장 경로 지정
          setMaxAge() : 쿠키 저장 기간
          ==> client에 쿠키 전송  response.addCookie()
       2. 쿠키 읽기
          Cookie[] cookies=request.getCookies();
          getName() => key를 읽어 온다 
          getValue() => 값을 읽어 온다 
       3. 쿠키 삭제 
          setMaxAge(0)
          
          ==> 5번 (fno)  ==> f5
    */
    if(cookies!=null)
    {
    	for(int i=cookies.length-1;i>=0;i--)
    	{
    		if(cookies[i].getName().startsWith("f"))
    		{
    			String no=cookies[i].getValue();
    			FoodVO vo=dao.foodDetailData(Integer.parseInt(no));
    			cList.add(vo);
    		}
    	}
    }
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
       <%--
             response => 전송 
             -------- 1) HTML 
                      2) Cookie 
                      ------------ 한개의 JSP에서는 두개를 동시 전송이 불가능 
        --%>
        <a class="food" href="detail_before.jsp?no=<%=vo.getFno()%>">
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
     <%--
           => php ,asp, node ...
           *****request,response => C(요청)/S(응답)
           *****session
           application , out 
           --------------------------------------------- 
           cookie : 일반 객체 ==> 자동로그인 , 최신방문 (로그인 = 아마존) => id ,pwd 
                                                -------------- 암호화  
           => 자신 컴퓨터 (로컬)
             1. 쿠키 사용법 ==> 쿠키의 단점 (저장되는 데이터가 문자열) , 세션 => Object
                = 쿠키 생성 
                  Cookie cookie=new Cookie(key,값)
                = 저장위치 지정 
                  setPath("/")
                = 기간 설정 
                  setMaxAge(초단위) => 60*60*24
                = 클라이언트로 전송 
                  addCookie
      --%>
     <h1>최신 본 맛집(쿠키)</h1>
     <a href="cookie_delete.jsp">쿠키삭제</a>
     <hr>
     <div>
       <%
          int k=0;
          for(FoodVO vo:cList)
          {
        	  if(k>9) break;
       %>
            <a href="food_detail.jsp?no=<%=vo.getFno()%>"><img src="<%=vo.getPoster().substring(0,vo.getPoster().indexOf("^")) %>" 
                       width=100 height="100"></a>
       <%
             k++;
          }
       %>
     </div>
</body>
</html>






