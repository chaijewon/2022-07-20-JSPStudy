package com.sist.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import com.sist.model.*;
import java.util.*;
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> clsList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try
		{
			String pack="com.sist.model";
			String path="C:\\webDev\\webStudy\\JSPMVCProject4\\src\\main\\java";
			String temp=path+"\\"+pack.replace(".", "\\");
			File dir=new File(temp);
			File[] files=dir.listFiles();
			for(File f:files)
			{
				//System.out.println(f.getName());
				String s=f.getName();
				String ext=s.substring(s.lastIndexOf(".")+1);
				if(ext.equals("java"))
				{
					//System.out.println(s);
					String fp=pack+"."+s.substring(0,s.lastIndexOf("."));
					System.out.println(fp);
					clsList.add(fp);
				}
				
			}
		}catch(Exception ex){}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 try {
			String cmd=request.getParameter("cmd");
			for(String ss:clsList)
			{  
				// ss=com.sist.model.ListModel
				// 
				if(ss.toUpperCase().contains(cmd.toUpperCase()))
				{
					Class clsName=Class.forName(ss);
					if(clsName.isAnnotationPresent(Control.class)==false)
						continue;// @Cotrol가 없으면 제외 (Model.java)
					Object obj=clsName.getDeclaredConstructor().newInstance();
					Model m=(Model)obj;
					String jsp=m.execute(request);
					RequestDispatcher rd=request.getRequestDispatcher(jsp);
					rd.forward(request, response);
					return;
				}
			    	
			}
	     }catch(Exception ex) {}
	}

}





