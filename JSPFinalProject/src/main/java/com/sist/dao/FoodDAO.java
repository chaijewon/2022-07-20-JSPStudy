package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.FoodCategoryVO;
import com.sist.vo.FoodVO;
import com.sist.vo.JjimVO;

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
   /*
    *     <select id="foodListData" resultType="FoodVO" parameterType="int">
		    SELECT fno,poster,name,tel,type
		    FROM food_house
		    WHERE cno=#{cno}
		  </select>
   */
   public static List<FoodVO> foodListData(int cno)
   {
	   SqlSession session=null;
	   List<FoodVO> list=null;
	   try
	   {
		   session=ssf.openSession();//connection 주소를 얻어 온다 
		   list=session.selectList("foodListData", cno);// while(rs.next())
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   session.close(); // 반환  ==> POOLED (connection : 8)
	   }
	   return list;
   }
   /*
		  <select id="foodCategoryInfoData" resultType="FoodCategoryVO" parameterType="int">
		    SELECT title,subject
		    FROM food_category
		    WHERE cno=#{cno}
		  </select>
    */
   public static FoodCategoryVO foodCategoryInfoData(int cno)
   {
	   SqlSession session=null;
	   FoodCategoryVO vo=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("foodCategoryInfoData",cno);
		   // WHERE cno=#{cno} ==> ?
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   session.close();
	   }
	   return vo;
   }
   /*
    *   <select id="foodDetailData" resultType="FoodVO" parameterType="int">
		    SELECT * FROM food_house
		    WHERE fno=#{fno}
		  </select>
		  
		  ==> select <select>
		        selectList (while(rs.next())
		        selectOne rs.next()
		      insert <insert>
		        insert
		      update <update>
		        update
		      delete <delete>
		        delete
		        
		        ? ==> parameterType
		          결과값 ==> resultType
    */
   public static FoodVO foodDetailData(int fno)
   {
	   SqlSession session=null;
	   FoodVO vo=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("foodDetailData",fno);//rs.next()
		   // WHERE cno=#{cno} ==> ?
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   session.close();
	   }
	   return vo;
   }
   
   /*
    *     <select id="foodLocationFindData" resultType="FoodVO" parameterType="hashmap">
		    SELECT fno,name,score,poeter,type,address,num
		    FROM (SELECT fno,name,score,poeter,type,address,rownum as num 
		    FROM (SELECT fno,name,score,poeter,type,address 
		    FROM food_location WHERE address LIKE '%'||#{address}||'%' ORDER BY fno ASC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <select id="foodLocationFindTotalPage" resultType="int" parameterType="string">
		    SELECT CEIL(COUNT(*)/12.0) FROM food_location
		    WHERE address LIKE '%'||#{address}||'%'
		  </select>
    */
   public static List<FoodVO> foodLocationFindData(Map map)
   {
	   List<FoodVO> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("foodLocationFindData", map);
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
   
   public static int foodLocationFindTotalPage(String address)
   {
	   int total=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   total=session.selectOne("foodLocationFindTotalPage", address);
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
    *   <insert id="foodJjimInsert" parameterType="com.sist.vo.JjimVO">
		    <selectKey keyProperty="no" resultType="int" order="BEFORE">
		     SELECT NVL(MAX(no)+1,1) as no FROM jjim
		    </selectKey>
		    INSERT INTO jjim VALUS(#{no},#{id},#{fno})
		  </insert>
  
		  <!-- 찜 여부 확인 -->
		  <select id="foodJjimCount" resultType="int" parameterType="com.sist.vo.JjimVO">
		    SELECT COUNT(*) FROM jjim
		    WHERE fno=#{fno} AND id=#{id}
		  </select>
    */
   public static void foodJjimInsert(JjimVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.insert("foodJjimInsert",vo);
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
   public static int foodJjimCount(JjimVO vo)
   {
	   int count=0;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   count=session.selectOne("foodJjimCount", vo);
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   if(session!=null)
			   session.close();
	   }
	   return count;
   }
   /*
    *   <select id="foodJjimListData" resultType="FoodVO" parameterType="int">
		    SELECT * FROM food_house
		    WHERE fno=#{fno}
		  </select>
    */
   public static FoodVO foodJjimListData(int fno)
   {
	   FoodVO vo=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   vo=session.selectOne("foodJjimListData", fno);
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
   /*
    *   <select id="foodJjimGetFno" resultType="int" parameterType="string">
		    SELECT fno FROM Jjim
		    WHERE id=#{id}
		  </select>
    */
   public static List<Integer> foodJjimGetFno(String id)
   {
	   List<Integer> list=null;
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession();
		   list=session.selectList("foodJjimGetFno",id);
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
   // 찜 취소
   /*
    *   <delete id="foodJjimDelete" parameterType="com.sist.vo.JjimVO">
   DELETE FROM Jjim
   WHERE id=#{id} AND fno=#{fno}
  </delete>
    */
   public static void foodJjimDelete(JjimVO vo)
   {
	   SqlSession session=null;
	   try
	   {
		   session=ssf.openSession(true);
		   session.delete("foodJjimDelete",vo);
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








