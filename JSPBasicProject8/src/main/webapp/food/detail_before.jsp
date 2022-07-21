<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
      String fno=request.getParameter("no");
      Cookie cookie=new Cookie("f"+fno,fno);// 중복이 없다
      cookie.setPath("/");
      cookie.setMaxAge(60*60*24);
      response.addCookie(cookie);
      //이동 
      response.sendRedirect("food_detail.jsp?no="+fno); 
      /*
           이동 / 데이터 전송 
           -------------- 
            GET 
              자바스크립트 : location.href 
              HTML : <a> , <form> 
              자바: sendRedirect , forward 
            POST
              자바스크립트 : ajax , axios (RestFul)  => List => [] , VO => {} => JSON
              HTML : <form> 
              
              
              -웹 브라우저가 보관하는 데이터이다.

              -웹 브라우저에서 서버로 어떤 데이터를 요청하고 서버로부터 응답을 받고 나면 관계가 종료된다.

              종료된 상태에서 어떤 정보를 지속적으로 유지하기 위해서 쿠키라는 방식을 사용한다.

              -쿠키는 클라이언트가 접속을 하면 서버 쪽에서 생성하여 해당 클라이언트에게 보내어 로컬 PC에 저장을 하는 방식이다.

              -저장할 수 있는 데이터가 제한적이다.

              -e.g.) 로그인시 아이디 값만 쿠키에 저장(비밀번호는 보안이 중요하므로 세션에서 관리)

              -점점 사라지는 추세(클라이언트->서버에서 처리)

               

               

              #도메인이나 path를 생략하면 그 쿠키를 생성한 JSP,경로,도메인을 기본값으로 가진다.


              #쿠키는 응답헤더를 통해서 넘어간다(flush후에 쿠키를 추가하면 안된다.)

               

               

              #쿠키 관련 메서드

              메서드 	리턴 타입 	설명
              getName()	String	쿠키 이름을 구한다.
              getValue()	String	쿠키 값을 구한다.
              setValue(String value)	void	쿠키 값을 지정한다.
              setPath(String uri)	void	쿠키를 전송할 경로를 지정한다.
              getPath()	String	쿠키의 전송 경로를 구한다.
              setMaxAge(int expiry)	void	쿠키의 요효시간을 초 단위로 지정한다. 음수를 입력할 경우 웹 브라우저를 닫을 떄 쿠키가 함께 삭제된다.
              getMaxAge()	int	쿠키의 유효시간을 구한다.
              
      */
%>