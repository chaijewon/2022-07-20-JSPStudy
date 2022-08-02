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
  <div id="breadcrumb" class="clear"> 
    <!-- ################################################################################################ -->
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">레시피</a></li>
      <li><a href="#">쉐프목록</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
  <h2 class="sectiontitle">쉐프 목록</h2>
  <%-- 쉐프 목록 출력 --%>
    <table class="table">
     <tr>
       <td>
         <c:forEach var="vo" items="${list }">
           <table class="table">
             <tr>
               <td width=30% class="text-center" rowspan="2">
                <a href="../recipe/chef_make.do?chef=${vo.chef }">
                 <img src="${vo.poster }" style="width: 100px;height: 100px" class="img-circle">
                </a>
               </td>
               <td colspan="4">
                 <a href="../recipe/chef_make.do?chef=${vo.chef }"><h3 style="color:orange">${vo.chef }</h3></a>
               </td>
             </tr>
             <tr>
               <td class="text-center">
                <img src="../recipe/images/mem1.png">${vo.mem_cont1 }
               </td>
               <td class="text-center">
                <img src="../recipe/images/mem2.png">${vo.mem_cont2 }
               </td>
               <td class="text-center">
                <img src="../recipe/images/mem7.png">${vo.mem_cont7 }
               </td>
               <td class="text-center">
                <img src="../recipe/images/mem3.png">${vo.mem_cont3 }
               </td>
             </tr>
           </table>
         </c:forEach>
       </td>
     </tr>
    </table>
    <%-- 페이지 출력 --%>
   <div class="row3">
     <div class="row" style="margin-left: 350px">
       <ul class="pagination">
         <%--
            startPage = 1, 11 , 21 , 31...
               curpage=10
          --%>
         <c:if test="${startPage>1 }">
		  <li><a href="../recipe/chef_list.do?page=${startPage-1 }">&laquo;</a></li>
		 </c:if>
			 <c:forEach var="i" begin="${startPage }" end="${endPage }">
			   <c:choose>
			     <c:when test="${i==curpage }">
			       <c:set var="style" value="class=active"/>
			     </c:when>
			     <c:otherwise>
			       <c:set var="style" value=""/>
			     </c:otherwise>
			   </c:choose>
			   <li ${style }><a href="../recipe/chef_list.do?page=${i }">${i }</a></li>
			 </c:forEach>
		  <c:if test="${endPage<totalpage }">
		   <li><a href="../recipe/chef_list.do?page=${endPage+1 }">&raquo;</a></li>
		  </c:if>
		</ul>
	 </div>
   </div>
  </main>
</div>
</body>
</html>











