package com.sist.dao;
/*
 *   ***1. 오라클을 연결해주는 드라이버 등록 (각 데이터베이스업체에서 지원) 
 *      oracle.jdbc.driver.OracleDriver
 *      com.mysql.cj.jdbc.Driver (MySQL) 
 *      ---------------------------------
 *       Class.forName(드라이버) 
 *   2. 연결 
 *      ***DriverManager.getConnection(URL,username,password) => conn hr/happy
 *      2-1. SQL문장 제작 (O) <>SQL</>
 *      ***2-2. SQL문장을 오라클로 전송 
 *      2-3. ?가 있는 경우에 값을 채운다 (O) parameterType
 *      ***2-4. 실행요청 
 *      ***2-5. 결과값을 VO에 담는다 (O) resultType
 *   3. 닫기 
 *       ***ps.close() , conn.close()
 *   ------------------------------------- 입문 (분석) => CURD
 */
import java.util.*;
import java.sql.*;
public class MovieDAO {
   private Connection conn;// 연결객체 (Socket)
   private PreparedStatement ps;// 전송객체 (BufferedReader,OutputStream) => 읽기/쓰기
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC => MyBatis (JPA)
   // 드라이버 등록 
   // Config.xml
   public MovieDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
   }
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex){}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   
   // mapper.xml
   public List<MovieVO> movieListData(int cno,int page)
   {
	   // cno = 1(상영영화) , 2(개봉예정)
	   List<MovieVO> list=new ArrayList<MovieVO>();
	   try
	   {
		   getConnection();
		   //1. SQL
		   String sql="SELECT mno,cno,poster,title,num "
				     +"FROM (SELECT mno,cno,poster,title,rownum as num "
				     +"FROM (SELECT mno,cno,poster,title "
				     +"FROM project_movie WHERE cno=? ORDER BY mno ASC)) "
				     +"WHERE num BETWEEN ? AND ?";
		   ps=conn.prepareStatement(sql);
		   //int rowSize=12;
		   //int start=(page*rowSize)-(rowSize-1);
		   ps.setInt(1, cno);
		   ps.setInt(2, (page*12)-11);
		   ps.setInt(3, page*12);
		   ResultSet rs=ps.executeQuery();// JDBC=> AutoCommit ==> false
		   while(rs.next())
		   {
			   MovieVO vo=new MovieVO();
			   vo.setMno(rs.getInt(1));
			   vo.setCno(rs.getInt(2));
			   vo.setPoster(rs.getString(3));
			   vo.setTitle(rs.getString(4));
			   
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
   
   // 총페이지 
   public int movieTotalPage(int cno)
   {
	   int total=0;
	   try
	   {
		   getConnection();
		   String sql="SELECT CEIL(COUNT(*)/12.0) FROM project_movie WHERE cno=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, cno);
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
   /*
    *   NO      NOT NULL NUMBER        
	CNO               NUMBER        
	TITLE             VARCHAR2(500) 
	GRADE             VARCHAR2(50)  
	RESERVE           VARCHAR2(20)  
	GENRE             VARCHAR2(200) 
	TIME              VARCHAR2(30)  
	REGDATE           VARCHAR2(200) 
	DIRECTOR          VARCHAR2(100) 
	ACTOR             VARCHAR2(200) 
	SHOWUSER          VARCHAR2(20)  
	POSTER            VARCHAR2(260) 
	STORY             CLOB          
	KEY               VARCHAR2(50)  
	HIT               NUMBER        
	SCORE             NUMBER(3,2)   
    */
   public MovieVO movieDetailData(int mno)
   {
	   MovieVO vo=new MovieVO();
	   try
	   {
		   getConnection();
		   String sql="SELECT mno,cno,title,grade,reserve,genre,time,regdate,director,actor,"
				     +"showuser,poster,key,score "
				     +"FROM project_movie "
				     +"WHERE mno=?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1,mno);
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   vo.setMno(rs.getInt(1));
		   vo.setCno(rs.getInt(2));
		   vo.setTitle(rs.getString(3));
		   vo.setGrade(rs.getString(4));
		   vo.setReserve(rs.getString(5));
		   vo.setGenre(rs.getString(6));
		   vo.setTime(rs.getString(7));
		   vo.setRegdate(rs.getString(8));
		   vo.setDirector(rs.getString(9));
		   vo.setActor(rs.getString(10));
		   vo.setShowuser(rs.getString(11));
		   vo.setPoster(rs.getString(12));
		   vo.setKey(rs.getString(13));
		   vo.setScore(rs.getDouble(14));
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










