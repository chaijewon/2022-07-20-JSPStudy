package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.Control;
@Control
public class ListModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "게시물 목록");
		return "view/list.jsp";
	}

}
