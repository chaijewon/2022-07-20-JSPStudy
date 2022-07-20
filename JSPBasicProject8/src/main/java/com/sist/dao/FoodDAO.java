package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.conn.*;
public class FoodDAO {
   private Connection conn;
   private PreparedStatement ps;
   private DBConnection dbconn=DBConnection.newInstance();
   
   // 목록 출력 
   public List<FoodVO> foodListData(String fd,int page)
   {
	   List<FoodVO> list=new ArrayList<FoodVO>();
	   try
	   {
		   // 검색별 페이지 나누기 
		   conn=dbconn.getConnection();
		   String sql="SELECT fno,poster,name,score,type,address,num "
				     +"FROM (SELECT fno,poster,name,score,type,address,rownum as num "
				     +"FROM (SELECT fno,poster,name,score,type,address "
				     +"FROM food_location WHERE address LIKE '%'||?||'%')) "
				     +"WHERE num BETWEEN ? AND ?";
		   // ajax 
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, fd);
		   int rowSize=9;
		   int start=(rowSize*page)-(rowSize-1);
		   int end=rowSize*page;
		   ps.setInt(2, start);
		   ps.setInt(3, end);
		   
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   FoodVO vo=new FoodVO();
			   vo.setFno(rs.getInt(1));
			   vo.setPoster(rs.getString(2));
			   vo.setName(rs.getString(3));
			   vo.setScore(rs.getDouble(4));
			   vo.setType(rs.getString(5));
			   vo.setAddress(rs.getString(6));
			   list.add(vo);
		   }
		   rs.close();
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();// 에러 확인 
	   }
	   finally
	   {
		   dbconn.disConnection(ps);
	   }
	   return list;
   }
   // 총페이지
   public int foodTotalPage(String fd)//findData
   {
	   int total=0;
	   try
	   {
		   conn=dbconn.getConnection();
		   String sql="SELECT CEIL(COUNT(*)/9.0) "
				     +"FROM food_location "
				     +"WHERE address LIKE '%'||?||'%'";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, fd);
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
		   dbconn.disConnection(ps);
	   }
	   return total;
   }
   // 상세 보기
   public FoodVO foodDetailData(int no)
   {
	   FoodVO vo=new FoodVO();
	   try
	   {
		   conn=dbconn.getConnection();
		   String sql="SELECT fno,poster,name,tel,score,type,price,parking,menu,time,address "
				     +"FROM food_location "
				     +"WHERE fno=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setFno(rs.getInt(1));
		   vo.setPoster(rs.getString(2));
		   vo.setName(rs.getString(3));
		   vo.setTel(rs.getString(4));
		   vo.setScore(rs.getDouble(5));
		   vo.setType(rs.getString(6));
		   vo.setPrice(rs.getString(7));
		   vo.setParking(rs.getString(8));
		   vo.setMenu(rs.getString(9));
		   vo.setTime(rs.getString(10));
		   vo.setAddress(rs.getString(11));
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbconn.disConnection(ps);
	   }
	   return vo;
   }
   // 로그인 처리
}







