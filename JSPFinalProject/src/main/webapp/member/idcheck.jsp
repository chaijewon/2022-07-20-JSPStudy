<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 30px;
  width:350px;
}
.row{
  margin: 0px auto;
  width: 100%;
}
</style>
</head>
<body>
   <div class="container">
     <div class="row">
      <table class="table">
        <tr>
          <td>
           입력:<input type=text name=id id=id size=15 class="input-sm">
           <input type=button value="아이디중복체크" class="btn btn-sm btn-primary">
          </td>
        </tr>
        <tr>
          <td class="text-center">
            <span id="print"></span>
          </td>
        </tr>
        <tr>
          <td id="ok"></td>
        </tr>
      </table>
     </div>
   </div>
</body>
</html>





