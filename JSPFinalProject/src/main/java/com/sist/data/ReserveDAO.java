package com.sist.data;
import java.util.*;
import java.sql.*;
public class ReserveDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   //드라이버 등록 
   public ReserveDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex){}
   }
   //연결 
   public void getConnection() // ==> session=ssf.openSession()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   //해제
   public void disConnection() // session.close()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   ////////////////////////////////////////// Config.xml 
   public void reserveDay(int rno,String time) // session.insert()
   {
	   try
	   {
		   getConnection();
		   String sql="INSERT INTO reserve_day VALUES(?,?)"; //<insert>SQL</insert> => id(Map => key) => 중복없이 사용 Locationdetail
	       ps=conn.prepareStatement(sql);
	       ps.setInt(1, rno);
	       ps.setString(2, time); // parameterType ==> #{rno},#{time}
	       ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   public List<Integer> foodGetFno()
   {
	   List<Integer> list=new ArrayList<Integer>();
	   try
	   {
		   getConnection();
		   String sql="SELECT fno FROM food_house ORDER BY fno ASC";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   int fno=rs.getInt(1);
			   list.add(fno);
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
   public void reserveDays(int fno,String rday)
   {
	   try
	   {
		   getConnection();
		   String sql="UPDATE food_house SET "
				     +"rday=? "
				     +"WHERE fno=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, rday);
		   ps.setInt(2, fno);
		   ps.executeUpdate();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
}




