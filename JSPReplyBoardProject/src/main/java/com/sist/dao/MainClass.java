package com.sist.dao;
import java.io.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	StringBuffer data=new StringBuffer();
        	FileInputStream fis=new FileInputStream("c:\\webDev\\food_location.sql");
        	int i=0;
        	while((i=fis.read())!=-1)
        	{
        		data.append((char)i);
        		//System.out.println(data);
        	}
        	fis.close();
        	System.out.println(data);
        }catch(Exception ex){}
	}

}
