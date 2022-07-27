package com.sist.controller;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private List<String> packList=new ArrayList<String>();
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try
		{
			URL url=this.getClass().getClassLoader().getResource(".");
			File file=new File(url.toURI());
			System.out.println(file.getPath());
			String path=file.getPath();
			path=path.replace("\\", File.separator);
			path=path.substring(0,path.lastIndexOf(File.separator));
			System.out.println(path);
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(new File(path+File.separator+"application.xml"));
			Element root=doc.getDocumentElement();
			System.out.println(root.getTagName());
			
			NodeList list=root.getElementsByTagName("component-scan");
			for(int i=0;i<list.getLength();i++)
			{
				Element cs=(Element)list.item(i);
				String value=cs.getAttribute("base-package");
				packList.add(value);
			}
			
			// 출력 
			for(String s:packList)
			{
				//System.out.println(s);
				path=path.substring(0,path.lastIndexOf(File.separator));
				System.out.println(path);
				String ss=path+File.separator+"WEB-INF"+File.separator+"classes"+File.separator+s.replace(".", File.separator);
				System.out.println(ss);
				File dir=new File(ss);
				File[] files=dir.listFiles();
				for(File f:files)
				{
					System.out.println(f.getName());
				}
			}
			
		}catch(Exception ex){}
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}









