<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="model" class="com.sist.model.BoardModel"/>
<%
    model.boardDetailData(request);
   /*
        request
          request.setAttribute("vo", vo);
   */
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
   width: 750px;
}

</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
let i=0;// 전역변수
$(function(){ // window.onload (Java=main())
	$('.btn-warning').click(function(){
		if(i==0)
		{
			$('#delTr').show();
			$('.btn-warning').text('취소');
			i=1;
		}
		else
		{
			$('#delTr').hide();
			$('.btn-warning').text('삭제');
			i=0;
		}
	})
	
	$('#delBtn').on("click",function(){
		let pwd=$('#pwd').val();
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		let no=$('#pwd').attr("data-no");
		
		$.ajax({
			type:'post',
			url:'delete.jsp',
			data:{"no":no,"pwd":pwd}, //delete.jsp?no=1&pwd=1234
			success:function(result)
			{
				let res=result.trim();
				if(res=="yes")
				{
					location.href="list.jsp";
				}
				else
				{
					alert("비밀번호가 틀립니다!");
					$('#pwd').val("");
					$('#pwd').focus();
				}
			}
		})
	})
})
</script>
</head>
<body>
   <div class="container">
     <div class="row">
	       <div class="text-right">
	         <img src="back.png" style="width:250px;height: 150px">
	       </div>
	</div>
	<div style="height: 20px"></div>
	<div class="row">
	  <table class="table">
	   <tr>
	    <th class="text-center success" width=20%>번호</th> 
	    <td class="text-center" width=30%>${vo.no }</td>
	    <th class="text-center success" width=20%>작성일</th> 
	    <td class="text-center" width=30%>${vo.regdate }</td>
	   </tr>
	   <tr>
	    <th class="text-center success" width=20%>이름</th> 
	    <td class="text-center" width=30%>${vo.name }</td>
	    <th class="text-center success" width=20%>조회수</th> 
	    <td class="text-center" width=30%>${vo.hit }</td>
	   </tr>
	   <tr>
	    <th class="text-center success" width=20%>제목</th> 
	    <td colspan=3>${vo.subject }</td>
	   </tr>
	   <tr>
	     <td colspan="4" valign="top" class="text-left" height="200"><pre style="white-space: pre-wrap;background-color:white;border:none">${vo.content }</pre></td>
	   </tr>
	   <tr>
	     <td colspan="4" class="text-right">
	       <a href="reply.jsp?pno=${vo.no}" class="btn btn-xs btn-danger">답변</a>
	       <a href="update.jsp?no=${vo.no }" class="btn btn-xs btn-info">수정</a>
	       <a href="#" class="btn btn-xs btn-warning">삭제</a>
	       <a href="list.jsp" class="btn btn-xs btn-success">목록</a>
	     </td>
	   </tr>
	   <tr id="delTr" style="display: none">
	     <td colspan="4" class="text-right">
	      <%-- HTML (태그는 사용자 정의(X) , 속성은 사용자 정의 --%>
	      비밀번호:<input type=password name=pwd size=15 class="input-sm" id="pwd" data-no="${vo.no }">
	      <input type=button id="delBtn" value="삭제" class="btn btn-sm btn-primary">
	     </td>
	   </tr>
	  </table>
	</div>
   </div>
</body>
</html>







