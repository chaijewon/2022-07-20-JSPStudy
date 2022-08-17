package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

@Controller
public class ReserveModel {
    @RequestMapping("reserve/reserve.do")
    public String reserve_main(HttpServletRequest request,HttpServletResponse response)
    {
    	request.setAttribute("main_jsp", "../reserve/reserve.jsp");
    	return "../main/main.jsp";
    }
}
