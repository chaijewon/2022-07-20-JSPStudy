<%@page import="com.sist.dao.DataBoardDAO"%>
<%@page import="com.sist.dao.DataBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.io.*,com.oreilly.servlet.*"%>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%--
   1. 화면 출력 
   2. 데이터만 받아서 처리 ==> 화면 이동 => sendRedirect()
--%>
<%
     try
     {
    	 request.setCharacterEncoding("UTF-8");
    	 //1. request
    	 //2. 파일 경로명
    	 String path="c:\\download";
    	 File dir=new File(path);
    	 if(!dir.exists())
    	 {
    		 dir.mkdir();
    	 }
    	 //3. 한글
    	 String enctype="UTF-8";
    	 //4. 크기 
    	 int maxsize=1024*1024*100;
    	 MultipartRequest mr=
    			 new MultipartRequest(request,path,maxsize,enctype,
    					 new DefaultFileRenamePolicy());
    	 // a.jpg ==> a1.jpg
    	 String name=mr.getParameter("name");
    	 String subject=mr.getParameter("subject");
    	 String content=mr.getParameter("content");
    	 String pwd=mr.getParameter("pwd");
    	 String filename=mr.getOriginalFileName("upload");
    	 DataBoardVO vo=new DataBoardVO();
    	 vo.setName(name);
    	 vo.setSubject(subject);
    	 vo.setContent(content);
    	 vo.setPwd(pwd);
    	 if(filename==null)
    	 {
    		 vo.setFilename("");
    		 vo.setFilesize(0);
    	 }
    	 else
    	 {
    		 File file=new File(path+"\\"+filename);
    		 vo.setFilename(filename);
    		 vo.setFilesize((int)file.length());
    	 }
         // 데이터베이스 연동 
         DataBoardDAO dao=new DataBoardDAO();
         dao.databoardInsert(vo);
         // 화면 이동 
         //response.sendRedirect("../main/main.jsp?mode=1");
     }catch(Exception ex){}
%>
<a href="../main/main.jsp?mode=1">목록으로 이동</a>






