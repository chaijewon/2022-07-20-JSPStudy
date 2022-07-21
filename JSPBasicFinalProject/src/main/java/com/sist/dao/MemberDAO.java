package com.sist.dao;
import java.util.*;

import com.sist.conn.DBConnection;

import java.sql.*;
public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   private DBConnection dbconn=DBConnection.newInstance();
   public String isLogin(String id,String pwd)
   {
	   // 결과값 => 경우 3개 (ID가 없는 경우 , 비밀번호가 틀리다 , 로그인)  ==> 가독성 , 최적화 
	   String result="";
	   try
	   {
		   conn=dbconn.getConnection();
		   //1 . ID가 체크 
		   String sql="SELECT COUNT(*) FROM jspMember "
				     +"WHERE id=?";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, id);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   int count=rs.getInt(1);
		   rs.close();
		   
		   if(count==0)//ID가 없는 경우
		   {
			   result="NOID";
		   }
		   else //ID가 있는 경우 
		   {
			   // pwd 검색 
			   sql="SELECT pwd,name FROM jspMember "
				  +"WHERE id=?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   String name=rs.getString(2);
			   rs.close();
			   
			   if(db_pwd.equals(pwd))//로그인 
			   {
				   result=name;
			   }
			   else //비밀번호가 틀린 상태 
			   {
				   result="NOPWD";
			   }
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   dbconn.disConnection(ps);
	   }
	   return result;
   }
}













