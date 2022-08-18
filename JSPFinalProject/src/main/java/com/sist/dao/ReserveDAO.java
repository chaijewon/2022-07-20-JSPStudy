package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodVO;
import com.sist.vo.ReserveVO;

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
   /*
    *   <insert id="reserveInsert" parameterType="com.sist.vo.ReserveVO">
		   <selectKey keyProperty="no" resultType="int" order="BEFORE">
		     SELECT NVL(Max(no)+1,1) as no FROM reserve
		   </selectKey>
		   INSERT INTO reserve(no,id,fno,rday,rtime,inwon)
		   VALUES(#{no},#{id},#{fno},#{rday},#{rtime},#{inwon})
		  </insert>
    */
   // 예약 
   public static void reserveInsert(ReserveVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);//autocommit
		   session.insert("reserveInsert",vo);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   /*
    *   <select id="reserveMypageData" resultType="com.sist.vo.ReserveVO" parameterType="string">
		    SELECT no,rday,rtime,inwon,ischeck,regdate,
		           (SELECT name FROM food_house WHERE fno=reserve.fno) as name,
		           (SELECT poster FROM food_house WHERE fno=reserve.fno) as poster,
		           (SELECT address FROM food_house WHERE fno=reserve.fno) as address,
		           (SELECT tel FROM food_house WHERE fno=reserve.fno) as tel,
		           (SELECT type FROM food_house WHERE fno=reserve.fno) as type
		    FROM reserve
		    WHERE id=#{id}
		    ORDER BY no DESC
		  </select>
    */
   public static List<ReserveVO> reserveMypageData(String id)
   {
	   List<ReserveVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("reserveMypageData", id);
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
   /*
    *   <select id="reserveAdminpageData" resultType="com.sist.vo.ReserveVO">
	    SELECT no,rday,rtime,inwon,ischeck,regdate,id,
	           (SELECT name FROM food_house WHERE fno=reserve.fno) as name,
	           (SELECT poster FROM food_house WHERE fno=reserve.fno) as poster,
	           (SELECT address FROM food_house WHERE fno=reserve.fno) as address,
	           (SELECT tel FROM food_house WHERE fno=reserve.fno) as tel,
	           (SELECT type FROM food_house WHERE fno=reserve.fno) as type
	    FROM reserve
	    WHERE ischeck&lt;&gt;'y'
	    ORDER BY no DESC
	  </select>
    */
   public static List<ReserveVO> reserveAdminpageData()
   {
	   List<ReserveVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("reserveAdminpageData");
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
   /*
    *   <update id="reserveAdminUpdate" parameterType="int">
		    UPDATE reserve SET
		    ischeck='y'
		    WHERE no=#{no}
		  </update>
    */
   public static void reserveAdminUpdate(int no)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.update("reserveAdminUpdate",no);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   /*
    *   <delete id="reserveCancel" parameterType="int">
		    DELETE FROM reserve
		    WHERE no=#{no}
		  </delete>
    */
   public static void reserveCancel(int no)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.delete("reserveCancel",no);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
   }
   
   /*
    *  <select id="reserveInfoData" resultType="com.sist.vo.ReserveVO" parameterType="int">
		    SELECT no,rday,rtime,inwon,ischeck,TO_CHAR(regdate,'YYYY"년도" MM"월" DD"일" HH24:MI:SS') as dbday,
		           (SELECT name FROM food_house WHERE fno=reserve.fno) as name,
		           (SELECT poster FROM food_house WHERE fno=reserve.fno) as poster,
		           (SELECT address FROM food_house WHERE fno=reserve.fno) as address,
		           (SELECT tel FROM food_house WHERE fno=reserve.fno) as tel,
		           (SELECT type FROM food_house WHERE fno=reserve.fno) as type
		    FROM reserve
		    WHERE no=#{no}
		  </select>
    */
   public static ReserveVO reserveInfoData(int no)
   {
	   ReserveVO vo=new ReserveVO();
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("reserveInfoData", no);
	   }catch(Exception ex)
	   {
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







