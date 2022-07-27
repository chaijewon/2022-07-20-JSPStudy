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
import javax.xml.parsers.*;
import org.w3c.dom.*;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Map clsMap=new HashMap();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		String path="C:\\webDev\\webStudy\\JSPMVCProject3\\src\\main\\webapp\\WEB-INF\\app.xml";
		try
		{
			// 파서기 생성 : XML , WML , HTML
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// 파서기 
			DocumentBuilder db=dbf.newDocumentBuilder();
			// 파싱된 데이터 저장 
			Document doc=db.parse(new File(path));
			// root 태그 읽기 
			Element root=doc.getDocumentElement();
			System.out.println(root.getTagName());
			// 같은 태그를 묶는다 
			NodeList list=root.getElementsByTagName("bean");
			//System.out.println(list);
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				System.out.println(id+" "+cls);
				// map에 저장 
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();// 메모리 할당 
				clsMap.put(id,obj);
				System.out.println(id+":"+obj);
			}
		}catch(Exception ex) {}
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cmd=request.getParameter("cmd");
		// Model 찾기
		Model model=(Model)clsMap.get(cmd);
		// JSP
		String jsp=model.execute(request);
		
		// request 전송 
		RequestDispatcher rs=request.getRequestDispatcher(jsp);
		rs.forward(request, response);
	}

}








