package com.sist.model;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.io.Reader;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.*;
import com.sist.dao.*;
/*
 *    USER 
 *      xxx.do   ===> DispatcherServlet ===> @RequestMapping("xxx.do")
 *                                           public String method(request, response)
 *                                           {
 *                                              ==========> DAO연동 
 *                                              request.setAttribute()
 *                                              return "xxx.jsp"
 *                                           }
 *                        ===> return 을 받는다 
 *                             ======= jsp
 *                             ======= jsp.forward(request,response)
 */
@Controller
public class RecipeModel {
	
   @RequestMapping("recipe/list.do")
   public String recipe_list(HttpServletRequest request,HttpServletResponse response)
   {
	   Map map=new HashMap();
	   map.put("start",1);
	   map.put("end", 12);
	   List<RecipeVO> list=RecipeDAO.recipeListData(map);
	   request.setAttribute("list", list);
	   return "../recipe/list.jsp";
   }
}






