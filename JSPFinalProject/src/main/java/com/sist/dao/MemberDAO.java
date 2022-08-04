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
	   
}







