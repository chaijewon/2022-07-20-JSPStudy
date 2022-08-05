<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <script type="text/javascript">
    $(function(){
    	favList();
    })
    function favList() {
        $.ajax({
            type : 'get',
            url : '../mypage/favorite_list.do',
            success : function(result) {
                $('#list').html(result);
            }
        });
    }
  </script>
</head>
<body>
  <div class="row border">
    <div class="col-md-12"><h3>&nbsp;&nbsp;<i class="fa fa-star" aria-hidden="true"></i> <b>마이페이지 / 즐겨찾기 관리</b></h3></div>
  </div>
  <div id="ad-title" class="row roomy-10">
    <div class="col-sm-3 text-center m-bottom-20 title-deco">회사명</div>
    <div class="col-sm-5 text-center m-bottom-20 title-deco">채용제목</div>
    <div class="col-sm-2 text-center m-bottom-20 title-deco">마감일</div>
    <div class="col-sm-2 text-center m-bottom-20 title-deco">&nbsp;</div>
  </div>
  <div id="list" class="roomy-10">
  
  
  </div>
</body>
</html>