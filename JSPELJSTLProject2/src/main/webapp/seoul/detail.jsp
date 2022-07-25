<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="model" class="com.sist.model.SeoulModel"/>
<%
     model.locationDetailData(request);
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
   width: 700px;
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <table class="table">
       <tr>
        <td class="text-center"><h3>${vo.title }</h3></td>
       </tr>
       <tr>
         <td class="text-center">
           <img src="${vo.poster }" style="width:100%">
         </td>
       </tr>
       <tr>
         <td>
          ${vo.msg }
         </td>
       </tr>
       <tr>
         <td>
          ${vo.address }
         </td>
       </tr>
      </table>
    </div>
  </div>
</body>
</html>




