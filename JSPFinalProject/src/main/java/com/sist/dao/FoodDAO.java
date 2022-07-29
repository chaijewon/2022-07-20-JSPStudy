package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodCategoryVO;

import java.io.*;
public class FoodDAO {
   // XML 파싱 => 등록된 데이터 읽기 
   private static SqlSessionFactory ssf;
   static // 자동 수행
   {
	   try
	   {
		   // XML 읽기 
		   //                 src/main/java => Config.xml  (classpath영역=>마이바티스 자동인식)
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   
   // getConnection , disConnection 
   public static List<FoodCategoryVO> foodCategoryData()
   {
	   SqlSession session=null;
	   List<FoodCategoryVO> list=null;
	   try
	   {
	      session=ssf.openSession();
	      list=session.selectList("foodCategoryData");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
	      session.close();
	   }
	   return list;
   }
}








