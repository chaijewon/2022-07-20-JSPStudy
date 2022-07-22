package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class LocationDAO {
    private Connection conn;
    private PreparedStatement ps;
    // DBCP ==> POOL(Connection 저장 => 관리) 
    // 연결 객체 가지고 오기 => getConnection => 생성이 아니고 생성된 객체를 가지고 온다 
    public void getConnection()
    {
    	try
    	{
    		// 저장된 위치를 가지고 온다 (JNDI) => java://comp/env => Connection객체 저장 
    		// 1. 탐색기 연다 
    		Context init=new InitialContext();
    		// 2. C드라이버 열기 
    		Context c=(Context)init.lookup("java://comp/env");
    		// 3. 저장된 폴더에서 => Connection을 읽어 온다 
    		DataSource ds=(DataSource)c.lookup("jdbc/oracle");
    		conn=ds.getConnection();// 미리생성된 Connection객체를 얻어온다 
    		// DL / DI => 스프링  => lookup => 이름으로 객체를 찾아 온다  ==> 객체마다 id 
    		// 톰캣 => 보안 
    	}catch(Exception ex){}
    }
    // 반환              => disConnection ==> ps.close(), conn.close()
    public void disConnection()
    {
    	try
    	{
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex){}
    }
    // 기능 ===> 동일 
    public List<LocationVO> locationListData(int page)
    {
    	List<LocationVO> list=new ArrayList<LocationVO>();
    	try
    	{
    		getConnection(); // 미리 생성된 Connection 객체 주소를 얻어 온다 
    		String sql="SELECT no,title,poster,num "
    				  +"FROM (SELECT no,title,poster,rownum as num "
    				  +"FROM (SELECT no,title,poster "
    				  +"FROM seoul_location ORDER BY no ASC)) "
    				  +"WHERE num BETWEEN ? AND ?";
    		// rownum을 이용시 => Top-N (중간에 있는 데이터는 가지고 오지 못한다)
    		ps=conn.prepareStatement(sql);
    		int rowSize=12;
    		int start=(rowSize*page)-(rowSize-1); 
    		int end=rowSize*page;
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
    		// 닫기 ==> 반환 (commons-dbcp.jar) => 다른 사용자가 재사용 (일정 Connection객체로 사용)
    		// 서버 부하가 작게 들어간다 
    		// 시간 => 분석 (아파치 로그)
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
}






