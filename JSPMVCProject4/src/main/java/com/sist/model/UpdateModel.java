package com.sist.model;

import javax.servlet.http.HttpServletRequest;

import com.sist.controller.Control;
@Control
public class UpdateModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		request.setAttribute("msg", "게시물 수정");
		return "view/update.jsp";
	}

}