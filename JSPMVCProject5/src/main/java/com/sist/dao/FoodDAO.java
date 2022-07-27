package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class FoodDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   
	   public void getConnection()
	   {
		   try
		   {
			   // 가상 => 탐색기 (JNDI) 
			   Context init=new InitialContext();
			   Context c=(Context)init.lookup("java://comp/env");
			   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			   conn=ds.getConnection();
		   }catch(Exception ex) {}
	   }
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex){}
	   }
	   public List<CategoryVO> categoryListData(int no)
	   {
		   List<CategoryVO> list=new ArrayList<CategoryVO>();
		   try
		   {
			   int start=0,end=0;
			   if(no==1) // 믿고 보는 맛집 리스트
			   {
				   start=1;
				   end=12;
			   }
			   else if(no==2) // 지역별 인기 맛집
			   {
				   start=13;
				   end=18;
			   }
			   else if(no==3) // 메뉴별 인기 맛집 
			   {
				   start=19;
				   end=30;
			   }
			   getConnection(); // 미리 생성된 Connection객체 얻기
			   String sql="SELECT cno,title,subject,poster "
					     +"FROM food_category "
					     +"WHERE cno BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   CategoryVO vo=new CategoryVO();
				   vo.setCno(rs.getInt(1));
				   vo.setTitle(rs.getString(2));
				   vo.setSubject(rs.getString(3));
				   vo.setPoster(rs.getString(4));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection(); //POOL로 재사용을 하기 위해 => 반환 
		   }
		   return list;
	   }
	   public List<FoodVO> food_list(int cno)
	   {
		   List<FoodVO> list=new ArrayList<FoodVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT fno,name,tel,type,poster,address "
					     +"FROM food_house "
					     +"WHERE cno=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, cno);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   FoodVO vo=new FoodVO();
				   vo.setFno(rs.getInt(1));
				   vo.setName(rs.getString(2));
				   vo.setTel(rs.getString(3));
				   vo.setType(rs.getString(4));
				   vo.setPoster(rs.getString(5));
				   vo.setAddress(rs.getString(6));
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
}
