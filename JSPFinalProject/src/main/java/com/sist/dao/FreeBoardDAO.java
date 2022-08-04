package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
import com.sist.vo.*;
public class FreeBoardDAO {
   private static SqlSessionFactory ssf;
   static
   {
	   try
	   {
		   // XML 읽기 
		   // src/main/java => Config.xml  (classpath영역=>마이바티스 자동인식)
		   Reader reader=Resources.getResourceAsReader("Config.xml");
		   ssf=new SqlSessionFactoryBuilder().build(reader);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
   }
   public static List<FreeBoardVO> boardListData(Map map)
   {
	   List<FreeBoardVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("boardListData",map);
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
   public static int boardTotalPage()
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   total=session.selectOne("boardTotalPage");
	   }catch(Exception ex)
	   {
		   System.out.println("boardTotalPage : error");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // POOL => 반환 
	   }
	   return total;
   }
   public static void boardInsert(FreeBoardVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);//openSession(true);
		   session.insert("boardInsert",vo); // commit(X)
		   //session.commit();
	   }catch(Exception ex)
	   {
		   System.out.println("boardTotalPage : error");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // POOL => 반환 
	   }
   }
   // <select id="boardDetailData" resultType="FreeBoardVO" parameterType="int">
   public static FreeBoardVO boardDetailData(int no)
   {
	   FreeBoardVO vo=new FreeBoardVO();
	   SqlSession session=null;
	   
	   try
	   {
		   // openSession() => setAutoCommit(false)
		   // openSession(true) => setAutoCommit(true)
		   session=ssf.openSession();
		   session.update("hitIncrement",no);//commit수행을 하지 않는다 
		   session.commit();//commit을 수행 요청 
		   vo=session.selectOne("boardDetailData",no);
	   }catch(Exception ex)
	   {
		   System.out.println("boardDetailData : error");
		   ex.printStackTrace();
		   //session.rollback();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // POOL => 반환 
	   }
	   return vo;
   }
   
   public static FreeBoardVO boardUpdateData(int no)
   {
	   FreeBoardVO vo=new FreeBoardVO();
	   SqlSession session=null;
	   
	   try
	   {
		   // openSession() => setAutoCommit(false)
		   // openSession(true) => setAutoCommit(true)
		   session=ssf.openSession();
		   vo=session.selectOne("boardDetailData",no);
	   }catch(Exception ex)
	   {
		   System.out.println("boardDetailData : error");
		   ex.printStackTrace();
		   //session.rollback();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // POOL => 반환 
	   }
	   return vo;
   }
   public static String boardPwdCheck(int no,String pwd)
   {
	   String result="";
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   String db_pwd=session.selectOne("boardGetPassword",no);
		   if(db_pwd.equals(pwd))
		   {
			   result="yes";
		   }
		   else
		   {
			   result="no";
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return result;
   }
   
   public static void boardUpdate(FreeBoardVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);//openSession(true);
		   session.update("boardUpdate",vo); // commit(X)
		   //session.commit();
	   }catch(Exception ex)
	   {
		   System.out.println("boardTotalPage : error");
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close(); // POOL => 반환 
	   }
   }
   
   public static String boardDelete(int no,String pwd)
   {
	   String result="";
	   // 오라클 연결 
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(); 
		   //<select id="boardGetPassword" resultType="string" parameterType="int">
		   /*
		    *  SELECT pwd FROM project_freeboard
               WHERE no=#{no}
               
               map.put("boardGetPassword","SELECT pwd FROM project_freeboard
               WHERE no=#{no}")
		    */
		   String db_pwd=session.selectOne("boardGetPassword", no);
		   if(db_pwd.equals(pwd))
		   {
			   result="yes";
			   /*
			    *  <delete id="boardDelete" parameterType="int">
				    DELETE FROM project_freeboard
				    WHERE no=#{no}
				   </delete>
			    */
			   session.delete("boardDelete",no);
			   session.commit();
		   }
		   else
		   {
			   result="no";
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return result;
   }
}




