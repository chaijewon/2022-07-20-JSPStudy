package com.sist.dao;
// DBCP
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class LocationDAO {
    private Connection conn;
    private PreparedStatement ps;
    // 미리 생성한 Connection의 주소를 얻어 온다 
    public void getConnection()
    {
    	try
    	{
    		Context init=new InitialContext();
    		Context c=(Context)init.lookup("java://comp/env");
    		DataSource ds=(DataSource)c.lookup("jdbc/oracle");
    		conn=ds.getConnection();
    	}catch(Exception ex){}
    }
    // 사용후에 재사용을 위해서 반환 
    public void disConnection()
    {
    	try
    	{
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex) {}
    }
    
    /*
     *    <dataSource type="POOLED">
     */
    public List<LocationVO> locationListData(int page)
    {
    	List<LocationVO> list=new ArrayList<LocationVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT no,title,poster,num "
    			      +"FROM (SELECT no,title,poster,rownum as num "
    				  +"FROM (SELECT no,title,poster "
    			      +"FROM seoul_location ORDER BY no ASC)) "
    				  +"WHERE num BETWEEN ? AND ?";
    		ps=conn.prepareStatement(sql);
    		int rowSize=12;
    		int start=(page*rowSize)-(rowSize-1);
    		int end=page*rowSize;
    		
    		ps.setInt(1, start);
    		ps.setInt(2, end);
    		
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			LocationVO vo=new LocationVO();
    			vo.setNo(rs.getInt(1));
    			vo.setTitle(rs.getString(2));
    			vo.setPoster(rs.getString(3));
    			list.add(vo);
    		}
    		rs.close();
    		
    	}catch(Exception ex) 
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return list;
    }
    // 총페이지 구하기 
    public int locationTotalPage()
    {
    	int total=0;
    	try
    	{
    		getConnection();
    		String sql="SELECT CEIL(COUNT(*)/12.0) FROM seoul_location";
    		ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		total=rs.getInt(1);
    		rs.close();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return total;
    }
    // nature
    public LocationVO natureDetailData(int no)
    {
    	LocationVO vo=new LocationVO();
    	try
    	{
    		getConnection();
    		String sql="SELECT no,title,poster,msg,address "
    				  +"FROM seoul_nature "
    				  +"WHERE no=?";
    		ps=conn.prepareStatement(sql);
    		ps.setInt(1, no);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		vo.setNo(rs.getInt(1));
    		vo.setTitle(rs.getString(2));
    		vo.setPoster(rs.getString(3));
    		vo.setMsg(rs.getString(4));
    		vo.setAddress(rs.getString(5));
    		rs.close();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return vo;
    }
    
    public List<LocationVO> natureListData(int page)
    {
    	List<LocationVO> list=new ArrayList<LocationVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT no,title,poster,num "
    			      +"FROM (SELECT no,title,poster,rownum as num "
    				  +"FROM (SELECT no,title,poster "
    			      +"FROM seoul_nature ORDER BY no ASC)) "
    				  +"WHERE num BETWEEN ? AND ?";
    		ps=conn.prepareStatement(sql);
    		int rowSize=12;
    		int start=(page*rowSize)-(rowSize-1);
    		int end=page*rowSize;
    		
    		ps.setInt(1, start);
    		ps.setInt(2, end);
    		
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			LocationVO vo=new LocationVO();
    			vo.setNo(rs.getInt(1));
    			vo.setTitle(rs.getString(2));
    			vo.setPoster(rs.getString(3));
    			list.add(vo);
    		}
    		rs.close();
    		
    	}catch(Exception ex) 
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return list;
    }
    // 총페이지 구하기 
    public int natureTotalPage()
    {
    	int total=0;
    	try
    	{
    		getConnection();
    		String sql="SELECT CEIL(COUNT(*)/12.0) FROM seoul_nature";
    		ps=conn.prepareStatement(sql);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		total=rs.getInt(1);
    		rs.close();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return total;
    }
    public LocationVO locationDetailData(int no)
    {
    	LocationVO vo=new LocationVO();
    	try
    	{
    		getConnection();
    		String sql="SELECT no,title,poster,msg,address "
    				  +"FROM seoul_location "
    				  +"WHERE no=?";
    		ps=conn.prepareStatement(sql);
    		ps.setInt(1, no);
    		ResultSet rs=ps.executeQuery();
    		rs.next();
    		vo.setNo(rs.getInt(1));
    		vo.setTitle(rs.getString(2));
    		vo.setPoster(rs.getString(3));
    		vo.setMsg(rs.getString(4));
    		vo.setAddress(rs.getString(5));
    		rs.close();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    	return vo;
    }
}







