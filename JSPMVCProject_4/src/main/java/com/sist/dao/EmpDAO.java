package com.sist.dao;
import java.util.*;
import java.sql.*;
// Model1 ==> MV ==> MVC (Spring) ==> Point 
public class EmpDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   ///////////////////////////////////////////
   // 드라이버 등록 
   public EmpDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   // 리플렉션 (클래스정보를 읽어와서 => 변수 초기화 , 메소드 호출) ==> 변수 초기화(Setter DI) , 
		   // 메소드 호출 (Method DI) ***** DI 필수 
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   // 오라클 연결 (메소드 => 한개 기능(재사용) , 중복을 제거)
   // 메소드 VS 함수 , 라이브러리 VS 프레임워크 , DAO VS Service  
   public void getConnection() // ssf.openSession()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   // 오라클 닫기 
   public void disConnection() // session.close()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   /////////////////////////////////////////// Config.xml
   // 기능 처리 
   // <select id="empListData" resultType="EmpVO">
   public List<EmpVO> empListData() // selectList => SQL , ? , 결과값
   {
	   List<EmpVO> list=new ArrayList<EmpVO>();
	   try
	   {
		   getConnection(); // session=ssf.openSession()
		   String sql="SELECT * FROM emp";
		   ps=conn.prepareStatement(sql);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next())
		   {
			   EmpVO vo=new EmpVO();
			   vo.setEmpno(rs.getInt(1)); // vo.setEmpno(rs.getInt("empno")) #{empno}
			   vo.setEname(rs.getString(2));
			   vo.setJob(rs.getString(3));
			   vo.setMgr(rs.getInt(4));
			   vo.setHiredate(rs.getDate(5));
			   vo.setSal(rs.getInt(6));
			   vo.setComm(rs.getInt(7));
			   vo.setDeptno(rs.getInt(8));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection(); // session.close()
	   }
	   return list;
   }
   /////////////////////////////////////////// mapper.xml(SQL, ResultType, ParameterType)
}









