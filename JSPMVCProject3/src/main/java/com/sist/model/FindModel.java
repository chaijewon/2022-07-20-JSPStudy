package com.sist.model;

import javax.servlet.http.HttpServletRequest;

public class FindModel implements Model {

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "게시물 찾기");
		return "view/find.jsp";
	}

}
