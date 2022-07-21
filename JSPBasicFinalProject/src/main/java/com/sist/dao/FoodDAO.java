package com.sist.dao;

import java.sql.*;
import java.util.*;
import com.sist.vo.*;
import com.sist.conn.DBConnection;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private DBConnection dbconn=DBConnection.newInstance();
	
	public List<CategoryBean> categoryListData()
	{
		List<CategoryBean> list=new ArrayList<CategoryBean>();
		try
		{
			conn=dbconn.getConnection();
			String sql="SELECT cno,title,poster "
					  +"FROM food_category "
					  +"ORDER BY cno ASC";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				CategoryBean vo=new CategoryBean();
				vo.setCno(rs.getInt(1));
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
			dbconn.disConnection(ps);
		}
		return list;
	}
}











