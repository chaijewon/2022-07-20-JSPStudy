package com.sist.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.*;
import com.sist.vo.*;
// 공통모듈 
public class MemberDAO {
	   private static SqlSessionFactory ssf;
	   static
	   {
		   try
		   {
			   // XML 읽기 
			   // src/main/java => Config.xml  (classpath영역=>마이바티스 자동인식)
			   Reader reader=Resources.getResourceAsReader("Config.xml");
			   ssf=new SqlSessionFactoryBuilder().build(reader);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
	   }
	   
	   // 아이디 중복체크 
	   /*
	    *  <select id="memberIdCheck" resultType="int" parameterType="string">
		     SELECT COUNT(*) FROM project_member
		     WHERE id=#{id}
		   </select>
	    */
	   public static int memberIdCheck(String id)
	   {
		   int count=0;
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   count=session.selectOne("memberIdCheck", id);
			   // selectList,selectOne ==> row
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();// 반환 (DBCP)
		   }
		   return count;
	   }
	   
	   public static int memberEmailCheck(String email)
	   {
		   int count=0;
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   count=session.selectOne("memberEmailCheck", email);
			   // selectList,selectOne ==> row
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();// 반환 (DBCP)
		   }
		   return count;
	   }
	   
	   public static int memberTelCheck(String tel)
	   {
		   int count=0;
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   count=session.selectOne("memberTelCheck", tel);
			   // selectList,selectOne ==> row
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();// 반환 (DBCP)
		   }
		   return count;
	   }
	   
	   // 회원 가입 
	   /*
	    *   ID       NOT NULL VARCHAR2(20)  
			PWD      NOT NULL VARCHAR2(10)  
			NAME     NOT NULL VARCHAR2(34)  
			SEX               VARCHAR2(10)  
			BIRTHDAY NOT NULL VARCHAR2(30)  
			EMAIL             VARCHAR2(100) 
			POST     NOT NULL VARCHAR2(20)  
			ADDR1    NOT NULL VARCHAR2(200) 
			ADDR2             VARCHAR2(200) 
			TEL               VARCHAR2(30)  
			CONTENT           CLOB          
			ADMIN             CHAR(1)       
			LOGIN             CHAR(1)  
	    */
	   // <insert id="memberInsert" parameterType="MemberVO">
	   /*
	    *   INSERT INTO project_member(id,pwd,name,sex,birthday,email,post,addr1,addr2,tel,content)
		     VALUES(
		       #{id},
		       #{pwd},
		       #{name},
		       #{sex},
		       #{birthday},
		       #{email},
		       #{post},
		       #{addr1},
		       #{addr2},
		       #{tel},
		       #{content}
		     )
	    */
	   public static void memberInsert(MemberVO vo)
	   {
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession(true);//autocommit
			   session.insert("memberInsert",vo);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();
		   }
	   }
	   // JSP => .do
	   
}







