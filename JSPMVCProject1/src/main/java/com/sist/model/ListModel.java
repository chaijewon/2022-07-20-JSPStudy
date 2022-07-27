package com.sist.model;

import javax.servlet.http.HttpServletRequest;
// Model => 요청처리 
public class ListModel {
  public void execute(HttpServletRequest request)
  {
	  request.setAttribute("msg", "게시판 목록");
  }
}
