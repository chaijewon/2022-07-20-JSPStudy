<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
   width: 700px;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
       <table class="table">
        <tr>
         <td>
           <%-- for(FoodVO vo:list) --%>
           <c:forEach var="vo" items="${list }">
              <table class="table">
                <tr>
                  <th width=30% class="text-center" rowspan="4">
                    <img src="${vo.poster }" style="width: 200px;height: 220px">
                  </th>
                  <td width=70%><h3>${vo.name }</h3></td>
                </tr>
                <tr>
                  <td width=70%>${vo.address }</td>
                </tr>
                <tr>
                  <td width=70%>${vo.tel }</td>
                </tr>
                <tr>
                  <td width=70%>${vo.type }</td>
                </tr>
              </table>
           </c:forEach>
         </td>
        </tr>
       </table>
     </div>
   </div>
</body>
</html>