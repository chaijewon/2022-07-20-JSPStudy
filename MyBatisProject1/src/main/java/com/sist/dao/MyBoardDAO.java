package com.sist.dao;
import java.util.*;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;
public class MyBoardDAO {
    private static SqlSessionFactory ssf;
    static
    {
    	try
    	{
    	    // XML 파싱 
    		Reader reader=Resources.getResourceAsReader("Config.xml");
    		ssf=new SqlSessionFactoryBuilder().build(reader);
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }
    // 기능 
    public static List<MyBoardVO> boardListData()
    {
    	return ssf.openSession().selectList("boardListData");
    }
    public static int boardCount()
    {
    	return ssf.openSession().selectOne("boardCount");
    }
}
