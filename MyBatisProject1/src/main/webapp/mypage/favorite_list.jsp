<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
    $(function(){
        $('.unfav-btn').click(function() {
        	if(confirm("정말 즐겨찾기를 해제하시겠습니까?")) {
        		let fid = $(this).attr("data-fav");
                $.ajax({
                    type: 'post',
                    url : '../favorite/delete.do',
                    data : {"fid" : fid},
                    success : function(result){
                        favList();
                    }
                });
        	}
        })
    })
</script>
<c:forEach var="a" items="${adlist }" varStatus="status">
  <div class="row">
    <div class="col-sm-3 text-center roomy-10 short-line">${clist[status.index] }</div>
    <div class="col-sm-5 text-center roomy-10 short-line"><a href="../ad/ad.do?adid=${a.ad_id}">${a.ad_title }</a></div>
    <div class="col-sm-2 text-center  roomy-10">${a.ad_end }</div>
    <div class="col-sm-2 text-center">
      <span class="unfav-btn btn btn-pink" data-fav="${favlist[status.index] }">즐겨찾기 해제</span>
    </div>
  </div>
  <hr>
</c:forEach>