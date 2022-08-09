<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.sist.dao.*"%>
<%--
      ~~.jsp , ~~.do(Model)    .do => model = jsp
      지시자 : page (import , 변환 코드) 
             taglib (제어문) 
                                     => 모든 JSP에서 공유    => getRealPath
      내장 객체 => request , response , session , cookie , application 
                사용자 요청   응답 (HTML,Cookie)
                getParameter()
                setAttribute() :  추가 
                setCharacterEncoding:디코딩  
      ------------------------------------------------- Spring , Spring-Boot
                                         request,response를 가급적 사용 금지 (권장)
                                         ================= 클래스 캡슐화 (Model) 
                                         class Model
                                         {
                                            HttpServletRequest request;
                                            public void addAttribute(String key,Object obj)
                                            {
                                               request.setAttribute(key,obj);
                                            }
                                         }
      EL  => ${requestScope.key} , ${sessionScope.key} , ${객체명.변수명}
      JSTL => <c:forEach> , <c:if> , <c:choose>
      
      ==> a.jsp?no=10
          a.jsp?no=10&page=1
          
          C/S ===> 주고 받고 
          --- 네트워크 
 --%>
<%
    EmpDAO dao=new EmpDAO();
    List<EmpVO> list=dao.empListData();//Model  ==> 순수하게 자바 ==> method 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width: 960px;
}
</style>
</head>
<body>
   <div class="container">
    <h1 class="text-center">사원 목록</h1>
    <div class="row">
      <table class="table table-hover">
       <tr class="danger">
         <th class="text-center">사번</th>
         <th class="text-center">이름</th>
         <th class="text-center">직위</th>
         <th class="text-center">사수번호</th>
         <th class="text-center">입사일</th>
         <th class="text-center">급여</th>
         <th class="text-center">성과급</th>
         <th class="text-center">부서번호</th>
       </tr>
       <%
          for(EmpVO vo:list)
          {
       %>
              <tr>
		         <td class="text-center"><%=vo.getEmpno() %></td>
		         <td class="text-center"><%=vo.getEname() %></td>
		         <td class="text-center"><%=vo.getJob() %></td>
		         <td class="text-center"><%=vo.getMgr() %></td>
		         <td class="text-center"><%=vo.getHiredate().toString() %></td>
		         <td class="text-center"><%=vo.getSal() %></td>
		         <td class="text-center"><%=vo.getComm() %></td>
		         <td class="text-center"><%=vo.getDeptno() %></td>
		       </tr>
       <%
          }
       %>
      </table>
    </div>
   </div>
</body>
</html>











