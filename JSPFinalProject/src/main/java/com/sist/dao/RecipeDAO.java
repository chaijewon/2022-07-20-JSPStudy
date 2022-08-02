package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.ChefVO;
import com.sist.vo.RecipeVO;

import java.io.*;
public class RecipeDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   try
	   {
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
		   // XML에 등록된 모든 데이터를 읽어서 저장 ==> HashMap (id=> 키 , sql값)
	   }catch(Exception ex)
	   {
		  ex.printStackTrace();
	   }
   }
   // <select id="recipeListData" resultType="RecipeVO" parameterType="hashmap">
   public static List<RecipeVO> recipeListData(Map map)
   {
	   List<RecipeVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("recipeListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // 반환 ==> POOLED(DBCP) => Connection생성(8개)
	   }
	   return list;
   }
   // <select id="chefListData" resultType="ChefVO" parameterType="hashmap">
   public static List<ChefVO> chefListData(Map map)
   {
	   List<ChefVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("chefListData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // 반환 ==> POOLED(DBCP) => Connection생성(8개)
	   }
	   return list;
   }
   // <select id="chefMakeRecipeData" resultType="RecipeVO" parameterType="hashmap">
   /*
    *       id= method명 
    *       resultType =  List<VO> , VO (selectOne)
    *                     selectList
    *       parameterType = 매개변수 
    */
   public static List<RecipeVO> chefMakeRecipeData(Map map)
   {
	   List<RecipeVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("chefMakeRecipeData",map);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // 반환 ==> POOLED(DBCP) => Connection생성(8개)
	   }
	   return list;
   }
   // <select id="recipeTotalPage" resultType="int">
   public static int recipeTotalPage()
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   total=session.selectOne("recipeTotalPage");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally 
	   {
		  if(session!=null)
			  session.close();
	   }
	   return total;
   }
   // <select id="chefTotalPage" resultType="int">
   public static int chefTotalPage()
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   total=session.selectOne("chefTotalPage");
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally 
	   {
		  if(session!=null)
			  session.close();
	   }
	   return total;
   }
   // <select id="chefMakeTotalPage" resultType="int" parameterType="string">
   public static int chefMakeTotalPage(String chef)
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   total=session.selectOne("chefMakeTotalPage",chef);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally 
	   {
		  if(session!=null)
			  session.close();
	   }
	   return total;
   }
   /*
    *    Web 
    *     = Java (메소드:리턴형 , 매개변수 => 라이브러리)
    *     = Oracle (DML) 
    */
}











