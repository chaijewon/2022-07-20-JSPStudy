package com.sist.controller;
import java.lang.reflect.Method;
import java.util.*;
class Model{
	@RequestMapping("list.do")
	public void aaa()
	{
		System.out.println("게시물 목록");
	}
	@RequestMapping("find.do")
	public void bbb()
	{
		System.out.println("게시물 찾기");
	}
	@RequestMapping("insert.do")
	public void ccc()
	{
		System.out.println("게시물 추가");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("URL:");
        String url=scan.next(); // list.do
        try
        {
        	Class clsName=Class.forName("com.sist.controller.Model");//class정보 읽기
        	// 멤버변수 ,메소드 호출 , 메모리 할당 
        	Object obj=clsName.getDeclaredConstructor().newInstance();
        	// new Model()
        	// 선언된 메소드 
        	Method[] methods=clsName.getDeclaredMethods();
        	for(Method m:methods)
        	{
        		RequestMapping rm=m.getAnnotation(RequestMapping.class);
        		if(url.equals(rm.value()))
        		{
        			m.invoke(obj, null);
        		}
        	}
        	
        }catch(Exception ex){}
	}

}





