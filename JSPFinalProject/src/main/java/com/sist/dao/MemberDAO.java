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
	   /*
	    *   <select id="memberIdCount" resultType="int" parameterType="string">
		     SELECT COUNT(*) 
		     FROM project_member
		     WHERE id=#{id}
		    </select>
		    <!-- 비밀번호 읽기 -->
		    <select id="memberInfoData" resultType="MemberVO" parameterType="string">
		      SELECT pwd,id,name,admin
		      FROM project_member
		      WHERE id=#{id}
		    </select>
	    */
	   public static MemberVO isLogin(String id,String pwd)
	   {
		   MemberVO vo=new MemberVO();
		   // 연결 ==> getConnection()
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession(); //DBCP => Connection을 미리 생성 (8) => 생성 Connection의 주소값 얻기
			   int count=session.selectOne("memberIdCount",id);
			   
			   if(count==0)
			   {
				   vo.setMsg("NOID");
			   }
			   else
			   {
				   vo=session.selectOne("memberInfoData", id);
				   if(pwd.equals(vo.getPwd())) //로그인
				   {
					   vo.setMsg("OK");
				   }
				   else //비밀번호가 틀린상태 
				   {
					   vo.setMsg("NOPWD");
				   }
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // POOL으로 반환 재사용 (미반환시 동작을 하지 않는다) => 스프링(처리)
		   }
		   return vo;
	   }
	   /*
	    *   <select id="memberDetailData" resultType="MemberVO" parameterType="string">
		      SELECT * FROM project_member
		      WHERE id=#{id}
		    </select>
	    */
	   // JSP(.do) ==> mapper ==> DAO ==> Model ==> JSP
	   public static MemberVO memberDetailData(String id)
	   {
		   MemberVO vo=new MemberVO();
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession(); //getConnection()
			   vo=session.selectOne("memberDetailData", id);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection()
		   }
		   return vo;
	   }
	   /*
	    *    <update id="memberUpdate" parameterType="MemberVO">
		      UPDATE project_member SET
		      name=#{name},sex=#{sex},email=#{email},
		      addr1=#{addr1},addr2=#{addr2},tel=#{tel},
		      content=#{content}
		      WHERE id=#{id}
		    </update>
	    */
	   public static boolean memberUpdate(MemberVO vo)
	   {
		   boolean bCheck=false;
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   MemberVO pvo=session.selectOne("memberInfoData", vo.getId());
			   if(pvo.getPwd().equals(vo.getPwd()))
			   {
				   bCheck=true;
				   session.update("memberUpdate",vo);
				   session.commit();
			   }
			   else
			   {
				  bCheck=false; 
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();
		   }
		   return bCheck;
	   }
	   /*
	    *   <delete id="memberDelete" parameterType="string">
		      DELETE FROM project_member
		      WHERE id=#{id}
		    </delete>
	    */
	   public static boolean memberDelete(String id,String pwd)
	   {
		   boolean bCheck=false;
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession();
			   MemberVO pvo=session.selectOne("memberInfoData", id);
			   if(pvo.getPwd().equals(pwd))
			   {
				   bCheck=true;
				   session.delete("memberDelete",id);
				   session.commit();
			   }
			   else
			   {
				  bCheck=false; 
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();
		   }
		   return bCheck;
	   }
	   
}







