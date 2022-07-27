package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel {
	 public void execute(HttpServletRequest request)
	  {
		  // DAO
		  request.setAttribute("msg", "데이터 추가");
	  }
}
