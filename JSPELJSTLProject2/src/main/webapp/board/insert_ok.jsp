<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.sist.model.*"%>
<jsp:useBean id="model" class="com.sist.model.BoardModel"/>
<%
    model.boardInsert(request, response);
%>
<%-- <%
    request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="vo" class="com.sist.dao.ReplyBoardVO">
  <jsp:setProperty name="vo" property="*"/>
</jsp:useBean> --%>
