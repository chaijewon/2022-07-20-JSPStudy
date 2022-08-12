package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class ReserveDAO {
  // XML을 파싱 => XML에 등록된 데이터 읽기
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
   *   <select id="foodListData" resultType="com.sist.dao.FoodVO" parameterType="string">
		    SELECT fno,name,poster,rownum
		    FROM food_location 
		    WHERE rownum&lt;=50
		    AND type LIKE '%'||#{type}||'%'
		    ORDER BY fno ASC
		  </select>
   */
  public static List<FoodVO> foodListData(String type)
  {
	  SqlSession session=ssf.openSession();
	  List<FoodVO> list=session.selectList("foodListData", type);
	  session.close();
	  return list;
  }
}








