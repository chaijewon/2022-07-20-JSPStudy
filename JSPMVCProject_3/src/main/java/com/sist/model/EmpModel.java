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
}
