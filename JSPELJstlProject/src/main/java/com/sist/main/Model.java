package com.sist.main;

import javax.servlet.http.HttpServletRequest;

public class Model {
   public void getSawonData(HttpServletRequest request)
   {
	   Sawon sa=new Sawon();
	   sa.setSabun(1);
	   sa.setName("박문수");
	   sa.setDept("개발부");
	   
	   request.setAttribute("sa", sa);
   }
}
