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
      <li><a href="#">커뮤니티</a></li>
      <li><a href="#">자유게시판</a></li>
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
    <h2 class="sectiontitle">자유게시판</h2>
    <div class="two_third first">
     <div style="height: 450px">
      <table class="table">
        <tr>
          <td>
            <a href="../freeboard/insert.do" class="btn btn-xs btn-danger">새글</a>
          </td>
        </tr>
      </table>
      <table class="table">
        <tr>
          <th width="10%" class="text-center">번호</th>
          <th width="45%" class="text-center">제목</th>
          <th width="15%" class="text-center">이름</th>
          <th width="20%" class="text-center">작성일</th>
          <th width="10%" class="text-center">조회수</th>
        </tr>
        <c:forEach var="vo" items="${list }">
        <tr>
          <%--
              adadadaadad (3) ==> reply ==> insert  freeboard=>rcount++
              
              .do ==> DispatcherServlet
                  ==> ~Model 
                      @RequestMapping(.do)
                      메소드 ==> 호출 
                      {
                          DB연동 
                          이동할 JSP지정 
                      }
           --%>
          <td width="10%" class="text-center">${vo.no }</td>
          <td width="45%"><a href="../freeboard/detail.do?no=${vo.no }">${vo.subject }</a>
            &nbsp;&nbsp;
            <c:if test="${vo.rcount>0 }">
             (${vo.rcount })
            </c:if>
          </td>
          <td width="15%" class="text-center">${vo.name }</td>
          <td width="20%" class="text-center">${vo.dbday }</td>
          <td width="10%" class="text-center">${vo.hit }</td>
        </tr>
        </c:forEach>
      </table>
      </div>
      <table class="table">
        <tr>
         <td class="text-left inline">
          <input type="checkbox" name=fd value="name">이름
          <input type="checkbox" name=fd value="subject">제목
          <input type="checkbox" name=fd value="content">내용
          <input type=text name=ss size=15 class="input-sm">
          <input type=button value=검색 class="btn btn-sm btn-primary">
         </td>
         <td class="text-right inline">
           <a href="#" class="btn btn-sm btn-success">이전</a>
           ${curpage } page / ${totalpage } pages
           <a href="#" class="btn btn-sm btn-info">다음</a>
         </td>
        </tr>
      </table>
    </div>
    <div class="one_third">2/3</div>
   </main>
   
</div>
</div>
</body>
</html>






