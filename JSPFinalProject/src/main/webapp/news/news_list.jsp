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
      <li><a href="#">뉴스</a></li>
    </ul>
    <!-- ################################################################################################ --> 
  </div>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row3">
  <main class="container clear"> 
    <!-- main body --> 
    <h2 class="sectiontitle">실시간 뉴스 검색</h2>
    <div class="row inline">
      <form method="post" action="../news/news_list.do">
       <input type=text name=fd size=35 class="input-sm">
       <input type=submit value="검색" class="btn btn-sm btn-primary">
      </form>
    </div>
    <div style="height: 20px"></div>
    <div class="row">
      <table class="table">
        <tr>
         <td>
           <c:forEach var="vo" items="${list }">
             <table class="table">
               <tr>
                 <td><span style="color:orange">${vo.title }</span></td>
               </tr>
               <tr>
                 <td><a href="${vo.link }" target="_blank">${vo.description }</a></td>
               </tr>
               <tr>
                 <td class="text-left">${vo.regdate }.${vo.author }</td>
               </tr>
             </table>
           </c:forEach>
         </td>
        </tr>
      </table>
    </div>
  </main>
</div>
</body>
</html>










