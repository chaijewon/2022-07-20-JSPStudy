package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

/*
 *    1. 요청 .do
 *       => DispatcherServlet => 요청정보(request) => Model <==> DAO
 *                       <= 처리내용 
 *                 |
 *               request를 JSP (출력 담당)
 */
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.dao.*;
@Controller
public class ReserveModel {
  @RequestMapping("reserve/reserve.do")
  public String reserve_main(HttpServletRequest request,HttpServletResponse response)
  {
	  return "../reserve/reserve.jsp";
  }
  @RequestMapping("reserve/select.do")
  public String food_select(HttpServletRequest request,HttpServletResponse response)
  {
	  String type=request.getParameter("type");
	  if(type==null)
		  type="한식";
	  List<FoodVO> list=ReserveDAO.foodListData(type);
	  request.setAttribute("list", list);
	  return "../reserve/select.jsp";
  }
}











