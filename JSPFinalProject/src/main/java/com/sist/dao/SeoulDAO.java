package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.SeoulLNSVO;

import java.io.*;
public class SeoulDAO {
   // 1. XML파일 읽기 
   private static SqlSessionFactory ssf;
   static
   {
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml"); 
		   ssf=new SqlSessionFactoryBuilder().build(reader);// 파싱 
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   // <select id="seoullnsListData" resultType="SeoulLNSVO" parameterType="hashmap">
   public static List<SeoulLNSVO> seoullnsListData(Map map)
   {
	   SqlSession session=null; // PreparedStatement 
	   // ssf  => Connection
	   List<SeoulLNSVO> list=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("seoullnsListData",map);
	   }catch(Exception ex)
	   {
		   System.out.println("seoullnsListData(Map map) : error");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null) // if(ps!=null) ps.close()
		   {
		      session.close();
		   }
	   }
	   return list;
   }
   // <select id="seoullnsTotalPage" resultType="int" parameterType="hashmap">
   public static int seoullnsTotalPage(Map map)
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   total=session.selectOne("seoullnsTotalPage", map);
	   }catch(Exception ex)
	   {
		   System.out.println("seoullnsTotalPage : error");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // POOL => 반환 
	   }
	   return total;
   }
   
   // 상세보기 
   public static SeoulLNSVO seoulDetailData(Map map)
   {
	    SeoulLNSVO vo=new SeoulLNSVO();
	    SqlSession session=null;
	    try
	    {
	    	session=ssf.openSession();
	    	vo=session.selectOne("seoullnsDetailData", map);//row
	    }catch(Exception ex)
	    {
	    	System.out.println("seoulDetailData: error");
	    	ex.printStackTrace();
	    }
	    finally
	    {
	    	if(session!=null)
	    		session.close();
	    }
	    return vo;
   }
}








