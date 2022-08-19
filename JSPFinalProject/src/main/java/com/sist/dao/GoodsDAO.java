package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sist.vo.GoodsVO;

import java.io.*;
/*
 *      public class SqlSession
 *      {
 *           private Connection conn;
 *           private PreparedStatement ps;
 *           private final String URL="";
 *           private final String DRIVER="";
 *           private final String USERNAME="";
 *           private final String PASSWORD="";
 *           
 *             <dataSource type="POOLED">
		          <property name="driver" value="oracle.jdbc.driver.OracleDriver"/>
		          <property name="url" value="jdbc:oracle:thin:@localhost:1521:XE"/>
		          <property name="username" value="hr"/>
		          <property name="password" value="happy"/>
		        </dataSource>
 *           
 *           public SqlSession()
 *           {
 *              try
 *              {
 *                 Class.forName(DRIVER);
 *              }catch(Exception ex)
 *              {
 *                 ex.printStackTrace();
 *              }
 *           }
 *           public void openSession(boolean bcheck)
 *           {
 *              try
 *              {
 *                 conn=DriverManager.getConnection(URL,USERNAME,PASSWORD)
 *                 if(bcheck==true)
 *                 {
 *                    conn.setAutoCommit(bcheck)
 *                 }
 *              }catch(Exception ex)
 *              {
 *                 ex.printStackTrace();
 *              }
 *           }
 *           public void close()
 *           {
 *           }
 *           
 *      }
 */
public class GoodsDAO {
    private static SqlSessionFactory ssf;
    // 자동인식 => 초기화 블록 
    static
    {
    	try
    	{
    		// XML 파싱 (Config.xml(Connection), Mapper(PrepardStatement,ResultSet)
    		// Config.xml(1) , Mapper는 table 갯수
    		// XML읽기
    		Reader reader=Resources.getResourceAsReader("Config.xml");
    		ssf=new SqlSessionFactoryBuilder().build(reader);
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
    
    /*
     *    <select id="goodsHomeData" resultType="GoodsVO" parameterType="string">
		    SELECT no,goods_poster as poster,goods_name as name,goods_price as price,rownum
		    FROM (SELECT no,goods_poster,goods_name,goods_price 
		    FROM ${table_name} ORDER BY no ASC)
		    WHERE rownum&lt;=3
		  </select>
     */
    public static List<GoodsVO> goodsHomeData(String table_name)
    {
    	List<GoodsVO> list=null;
    	SqlSession session=null;
    	try
    	{
    		session=ssf.openSession();
    		list=session.selectList("goodsHomeData", table_name);
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
     *    <!--  데이터 출력  -->
		  <select id="goodsListData" resultType="GoodsVO" parameterType="hashmap">
		    SELECT no,goods_poster as poster,goods_name as name,goods_price as price,num
		    FROM (SELECT no,goods_poster,goods_name,goods_price,rownum as num
		    FROM (SELECT no,goods_poster,goods_name,goods_price
		    FROM ${table_name} ORDER BY no ASC))
		    WHERE num BETWEEN #{start} AND #{end}
		  </select>
		  <!-- 총페이지 -->
		  <select id="goodsTotalPage" resultType="int" parameterType="string">
		    SELECT CEIL(COUNT(*)/9.0) FROM ${table_name}
		  </select>
     */
    // 목록 읽기 
    public static List<GoodsVO> goodsListData(Map map)
    {
    	List<GoodsVO> list=null;
    	SqlSession session=null;
    	try
    	{
    		session=ssf.openSession();
    		list=session.selectList("goodsListData", map);
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
    // 총페이지 구하기 
    public static int goodsTotalPage(String table_name)
    {
    	int total=0;
    	SqlSession session=null;
    	try
    	{
    		session=ssf.openSession();
    		total=session.selectOne("goodsTotalPage", table_name);
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
     *   <select id="goodsDetailData" resultType="GoodsVO" parameterType="hashmap">
		    SELECT * FROM ${table_name}
		    WHERE no=#{no}
		  </select>
     */
    public static GoodsVO goodsDetailData(Map map)
    {
    	GoodsVO vo=new GoodsVO();
    	SqlSession session=null;
    	try
    	{
    		session=ssf.openSession();
    		vo=session.selectOne("goodsDetailData", map);
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







