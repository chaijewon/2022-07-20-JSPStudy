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
   // 예약일 읽기
   /*
    *   <select id="reserveGetDate" resultType="string" parameterType="int">
		    SELECT rday FROM food_house
		    WHERE fno=#{fno}
		  </select>
    */
   public static String reserveGetDate(int fno)
   {
	   String rday="";
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   rday=session.selectOne("reserveGetDate", fno);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return rday;
   }
   /*
    *  <select id="reserveGetTime" resultType="string" parameterType="int">
		    SELECT time FROM reserve_day
		    WHERE rno=#{rno}
		  </select>
		  <select id="reserveRealTime" resultType="string" parameterType="int">
		    SELECT time FROM reserve_time
		    WHERE tno=#{tno}
		  </select>
    */
   public static String reserveGetTime(int rno)
   {
	   String rtime="";
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   rtime=session.selectOne("reserveGetTime", rno);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return rtime;
   }
   
   public static String reserveRealTime(int tno)
   {
	   String rtime="";
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   rtime=session.selectOne("reserveRealTime", tno);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return rtime;
   }
}







