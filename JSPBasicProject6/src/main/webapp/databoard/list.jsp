<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%
     DataBoardDAO dao=new DataBoardDAO();
     // 페이지 => 사용자가 처음에는 선택이 안된다 
     String strPage=request.getParameter("page"); //page는 내장 객체(this)
     if(strPage==null)
    	 strPage="1";// 디폴트 페이지 
     /*
          list.jsp ============> null ==> page==null
          list.jsp?page=  =====> ""   ==> page.equals("")
     */
     // 현재 페이지 지정 
     int curpage=Integer.parseInt(strPage);
     // 실제 데이터를 오라클에서 가지고 온다 => DAO
     List<DataBoardVO> list=dao.databoardListData(curpage);
     // 총페이지 
     int totalpage=dao.databoardTotalPage();
     // list.jsp에 출력해야 할 데이터를 설정 
     // <a> => 새로운 list.jsp를 수행 
     /*
         이동 => <a> <form> 
         ------------------
           list.jsp => list_jsp  => new list_jsp() => destory()
                                    new list_jsp() => destory()
     */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../databoard/table.css">
<style type="text/css">
.container{
   width:100%;
   margin-top: 50px;
}
h1{
   text-align: center
}
.table_content{
   margin: 0px auto;
   width:700px;
}
a{
   text-decoration: none;
   color:balck;
}
a:hover{
   text-decoration: underline;
   color:green;
}
</style>
</head>
<body>
  <div class="container">
    <h1>자료실</h1>
    <table class="table_content">
      <tr>
        <td>
         <a href="../main/main.jsp?mode=2">새글</a>
        </td>
      </tr>
    </table>
    <table class="table_content">
     <tr>
       <th width=10%>번호</th>
       <th width=45%>제목</th>
       <th width=15%>이름</th>
       <th width=20%>작성일</th>
       <th width=10%>조회수</th>
     </tr>
     <%-- 데이터 출력 --%>
     <%
        for(DataBoardVO vo:list)
        {
     %>
             <tr>
		       <td width=10% align=center><%= vo.getNo() %></td>
		       <td width=45%><a href="../main/main.jsp?mode=3&no=<%=vo.getNo()%>"><%= vo.getSubject() %></a>
		        &nbsp;
		        <%
		            String today=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		            if(today.equals(vo.getRegdate().toString()))
		            {
		        %>
		              <span style="color:red"><sup>new</sup></span>
		        <%
		            }
		        %>
		       </td>
		       <td width=15% align=center><%= vo.getName() %></td>
		       <td width=20% ><%= vo.getRegdate().toString() %></td>
		       <td width=10% align=center><%=vo.getHit() %></td>
		     </tr>
     <%
        }
     %>
    </table>
    <table class="table_content">
      <tr>
       <td align=left>
        Search:<select name=fs>
          <option value="name">이름</option>
          <option value="subject">제목</option>
          <option value="content">내용</option>
        </select>
        <input type=text name=ss size=15>
        <input type=submit value="검색">
       </td>
       <td align=right>
         <a href="list.jsp?page=<%=curpage>1?curpage-1:curpage%>">이전</a>&nbsp;
         <%=curpage %> page / <%=totalpage %> pages
         <a href="list.jsp?page=<%= curpage<totalpage?curpage+1:curpage%>">다음</a>
       </td>
      </tr>
    </table>
  </div>
</body>
</html>



