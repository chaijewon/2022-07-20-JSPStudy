package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class DeleteModel {
	  public void execute(HttpServletRequest request)
	  {
		  request.setAttribute("msg", "게시물 삭제");
	  }
}
