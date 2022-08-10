<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
    String cno=request.getParameter("cno");
    if(cno==null)
    	cno="1";
    
    String strPage=request.getParameter("page");
    if(strPage==null)
    	strPage="1";
    int curpage=Integer.parseInt(strPage);
    
    MovieDAO dao=new MovieDAO();
    
    List<MovieVO> list=dao.movieListData(Integer.parseInt(cno), curpage);
    // ${request.getAttribute()} => request.setAttribute()
    int totalpage=dao.movieTotalPage(Integer.parseInt(cno));
    
    // 쿠키 
    Cookie[] cookies=request.getCookies(); //쿠키 읽기
    List<MovieVO> cList=new ArrayList<MovieVO>();
    if(cookies!=null)
    {
    	for(int i=cookies.length-1;i>=0;i--) // 최신부터 출력 
    	{
    		if(cookies[i].getName().startsWith("movie")) //movie1
    		{
    			String mno=cookies[i].getValue();// 1
    			MovieVO vo=dao.movieDetailData(Integer.parseInt(mno));
    			cList.add(vo);
    		}
    	}
    }
    
%>
<%--
      
         list.jsp ==> request(톰캣) => ip , port , 사용자 요청 정보 (?~~)
         1) JSP 
              => 자바 코딩 
                 HTML , Java => 구분 
                 <%
                     자바 
                 %>
                 <%= %> => 데이터 출력 
              => 내장 객체 (미리 객체가 생성됨)
                  request (HttpServletRequest)
                    사용자 정보 , 요청 정보 
                    ------------------ 
                      = getParameter()
                      = getParameterValues() ==> checkbox 
                      = setCharacterEncoding() ==> 한글변환 
                      = getSession() : session 객체를 가지고 온다 
                      = getCookie() : cookie 읽기 
                      = setAttribute() => 기존의 데이터+새로운 데이터를 추가 
                  response (HttpServletResponse)
                     응답 정보 , 화면 변경 
                   --------------------
                     응답 : HTML , Cookie  ==> 둘중에 한개 설정 
                     setContextType("text/html",text/xml,text/plain(JSON))
                     addCookie() : 쿠키 전송 
                     sendRedirect() : 서버에서 화면 이동 
                     --------------  insert,update,delete 
                  session (HttpSession) : 서버에 클라이언트의 일부 정보를 저장 (프로젝트에서 사용하는 모든 JSP에서 사용이 가능)
                    => id , 장바구니 
                    => setAttribute(String key,Object obj) , getAttribute() , invalidate() , removeAttribute()
                        저장               자정값 읽기        전체 메모리 해제    일부를 메모리 해제 
                  cookie  (Cookie:내장 객체가 아니다) : 클라이언트 브라우저 (방문)
                    => 쿠키 생성  Cookie cookie=new Cookie(키,값)
                                                           --- 문자열만 저장이 가능 
                    => 기간 설정  setMaxAge(초단위) => 60*60*24 
                    => 저장 위치  setPath("/")
                    => 브라우저로 전송 response.addCookie()
                    => 쿠키 읽기 
                       Cookie[] cookies=request.getCookies()
                       ==> 키   : getName()
                       ==> 값   : getValue()
              => DataBase : DAO
                 
              ***Java : 데이터 관리 (오라클을 연결)
              JavaScript : 이벤트 처리 (브라우저안에서 동적) ==> 웹프로그래머 
              HTML/CSS : 화면만 출력 (정적)
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container-fluid{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 100%;
}
</style>
</head>
<body>
<div class='container-fluid'>
    <div class="row">
     <div class="text-right">
      <a href="list.jsp?cno=1" class="btn btn-sm btn-success">현재 상영 영화</a>
      <a href="list.jsp?cno=2" class="btn btn-sm btn-info">개봉 예정 영화</a>
     </div>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <%-- for(CategoryVO vo:list) --%>
      <%
          for(MovieVO vo:list)
          {
      %>
        <div class="col-md-3">
	      <div class="thumbnail">
	        <a href="detail_before.jsp?mno=<%= vo.getMno()%>">
	          <img src="<%=vo.getPoster() %>" alt="Lights" style="width:300px;height: 300px">
	          <div class="caption">
	            <p><%=vo.getTitle() %></p>
	          </div>
	        </a>
	      </div>
	    </div>
      <%
          }
      %>
    </div>
    <div class="row">
      <div class="text-center">
        <a href="list.jsp?cno=<%=cno %>&page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-info">이전</a>
        <%=curpage %> page / <%=totalpage %> pages
        <a href="list.jsp?cno=<%=cno %>&page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-warning">다음</a>
      </div>
    </div>
    <div style="height: 10px"></div>
    <div class="row">
    <h3>최근 방문 영화</h3>
    <hr>
     <%
        for(MovieVO vo:cList)
        {
     %>
          <img src="<%=vo.getPoster() %>" style="width: 100px;height: 100px">
     <%
        }
     %>
    </div>
  </div>
</body>
</html>