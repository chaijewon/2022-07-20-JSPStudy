package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodVO;

import java.io.*;
public class ReserveDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   /*
    *    <select id="reserveFoodData" resultType="FoodVO" parameterType="string">
		    SELECT fno,poster,name,rownum
		    FROM (SELECT fno,poster,name FROM food_house WHERE type LIKE '%'||#{type}||'%' ORDER BY fno ASC)
		    WHERE rownum&lt;=50
		  </select>
    */
   public static List<FoodVO> reserveFoodData(String type)
   {
	   List<FoodVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("reserveFoodData", type);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return list;
   }
}







