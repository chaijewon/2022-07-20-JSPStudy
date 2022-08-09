package com.sist.model;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.dao.*;
public class EmpModel {
   public void empListData(HttpServletRequest request)
   {
	    EmpDAO dao=new EmpDAO();
	    List<EmpVO> list=dao.empListData();
	    // list=> jsp로 전송 
	    request.setAttribute("list", list); 
   }
   public void empDetailData(HttpServletRequest request)
   {
	    EmpDAO dao=new EmpDAO();
	    String empno=request.getParameter("empno");
	    EmpVO vo=dao.empDetailData(Integer.parseInt(empno));
	    // list=> jsp로 전송 
	    request.setAttribute("vo", vo); 
   }
}
