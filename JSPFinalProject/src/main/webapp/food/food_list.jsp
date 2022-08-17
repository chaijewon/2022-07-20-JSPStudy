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
     <div class="jumbotron">
       <h2 class="text-center" style="color:black">${vo.title }</h2>
       <h4 class="text-center">${vo.subject }</h4>
     </div>
     <div class="row">
      <table class="table">
        <tr>
         <td>
           <c:forEach var="fvo" items="${list }">
             <table class="table">
               <tr>
                 <td width=30% class="text-center" rowspan="4">
                   <a href="../food/food_detail_before.do?fno=${fvo.fno }"><img src="${fvo.poster }" style="width: 280px;height: 220px;"></a>
                 </td>
                 <td width=70%>
                   <h4><a href="../food/food_detail_before.do?fno=${fvo.fno }">${fvo.name }</a>&nbsp;<span style="color:orange">${fvo.score }</span></h4>
                 </td>
               </tr>
               <tr>
                 <td width=70%>${fvo.address }</td>
               </tr>
               <tr>
                 <td width=70%>${fvo.tel }</td>
               </tr>
               <tr>
                 <td width=70%>${fvo.type }</td>
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