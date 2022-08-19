package com.sist.temp;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class GoodsDAO {
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
    *   <insert id="goodsAllInsert" parameterType="com.sist.temp.GoodsVO">
		   <selectKey keyProperty="no" resultType="int" order="BEFORE">
		     SELECT NVL(MAX(no)+1,1) as no FROM goods_all
		   </selectKey>
		   INSERT INTO goods_all VALUES(
		     #{no},
		     #{goods_name},
		     #{goods_sub},
		     #{goods_price},
		     #{goods_discount},
		     #{goods_first_price},
		     #{goods_delivery}
		   )
		 </insert>
    */
   public static void goodsAllInsert(GoodsVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.insert("goodsAllInsert",vo);
		   
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
   public static void goodsBestInsert(GoodsVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.insert("goodsBestInsert",vo);
		   
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
   public static void goodsSpecialInsert(GoodsVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.insert("goodsSpecialInsert",vo);
		   
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
   public static void goodsNewInsert(GoodsVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.insert("goodsNewInsert",vo);
		   
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
}
