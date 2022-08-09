package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
  /*
   *   <select id="recipeListData" resultType="com.sist.vo.RecipeVO" parameterType="hashmap">
		    SELECT no,title,poster,chef,num
		    FROM (SELECT no,title,poster,chef,rownum as num
		    FROM (SELECT no,title,poster,chef 
		    FROM recipe ORDER BY no ASC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
   */
	public static List<RecipeVO> recipeListData(Map map)
	{
		SqlSession session=ssf.openSession();
		List<RecipeVO> list=session.selectList("recipeListData",map);
		session.close();
		return list;
	}
}
