package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class MovieDAO {
  private static SqlSessionFactory ssf;
  static
  {
	  try
	  {
		  Reader reader=Resources.getResourceAsReader("Config.xml");
		  ssf=new SqlSessionFactoryBuilder().build(reader);
	  }catch(Exception ex){}
  }
  /*
   *   <select id="movieListData" resultType="com.sist.dao.MovieVO" parameterType="hashmap">
	   SELECT mno,cno,poster,title,num 
	   FROM (SELECT mno,cno,poster,title,rownum as num 
	   FROM (SELECT mno,cno,poster,title 
	   FROM project_movie WHERE cno=#{cno} ORDER BY mno ASC)) 
	   WHERE num BETWEEN #{start} AND #{end}
	  </select>
	  <!-- 
	     map.put("start",1) => #{start} => map.get("start")
	   -->
	   <select id="movieDetailData" resultType="com.sist.dao.MovieVO" parameterType="int">
	    SELECT mno,cno,title,grade,reserve,genre,time,regdate,director,actor,
			   showuser,poster,key,score 
	    FROM project_movie 
		WHERE mno=#{mno};
	   </select>
	   
	   <select id="movieTotalPage" resultType="int" parameterType="int">
	    SELECT CEIL(COUNT(*)/12.0) FROM project_movie WHERE cno=#{cno}
	   </select>
   */
  public static List<MovieVO> movieListData(Map map)
  {
	  SqlSession session=ssf.openSession();
	  List<MovieVO> list=session.selectList("movieListData",map);
	  session.close();
	  return list;
  }
  public static MovieVO movieDetailData(int mno)
  {
	  SqlSession session=ssf.openSession();
	  MovieVO vo=session.selectOne("movieDetailData",mno);
	  session.close();
	  return vo;
  }
  public static int movieTotalPage(int cno)
  {
	  SqlSession session=ssf.openSession();
	  int total=session.selectOne("movieTotalPage",cno);
	  session.close();
	  return total;
  }
}
