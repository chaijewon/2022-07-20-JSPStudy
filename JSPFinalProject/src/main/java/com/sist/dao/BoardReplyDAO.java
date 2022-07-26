package com.sist.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.*;
import com.sist.vo.*;

/*
 *    DAO => DAO+mapper+VO(데이터베이스 연결)
 *    Model => VO+DAO호출 (요청값을 전송) ==> JSP
 */
public class BoardReplyDAO {
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
	   /*
	    *   <select id="boardReplyListData" resultType="BoardReplyVO" parameterType="hashmap">
			    SELECT no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,hit,isreply,group_id,group_tab,num
			    FROM (SELECT no,subject,name,regdate,hit,isreply,group_id,group_tab,rownum as num
			    FROM (SELECT no,subject,name,regdate,hit,isreply,group_id,group_tab
			    FROM project_replyBoard ORDER BY group_id DESC,group_step ASC))
			    WHERE num BETWEEN #{start} AND #{end}
			  </select>
	    */
	   public static List<BoardReplyVO> boardReplyListData(Map map)
	   {
		   SqlSession session=null;
		   List<BoardReplyVO> list=null;
		   try
		   {
			   session=ssf.openSession();
			   list=session.selectList("boardReplyListData",map);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close();
		   }
		   return list;
	   }
	   /*
	    *   <insert id="boardReplyInsert" parameterType="BoardReplyVO">
			    <selectKey keyProperty="no" resultType="int" order="BEFORE">
			      SELECT NVL(MAX(no)+1,1) as no FROM project_replyBoard
			    </selectKey>
			    INSERT INTO project_replyBoard(no,name,subject,content,pwd,group_id)
			    VALUES(#{no},#{name},#{subject},#{content},#{pwd},
			     SELECT NVL(MAX(group_id)+1,1) as no FROM project_replyBoard
			    )
			  </insert>
	    */
	   public static void boardReplyInsert(BoardReplyVO vo)
	   {
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession(true);// getConnection() : 미리 생성된 Connection주소 읽기 
			   // autocommit ==> 트랜잭션 
			   session.insert("boardReplyInsert",vo);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection() ps.close(),conn.close() : 반환 
		   }
	   }
	   
	   /*
	    *   <select id="boardReplyTotalPage" resultType="int">
			    SELECT CEIL(COUNT(*)/10.0) FROM project_replyBoard
			  </select>
	    */
	   public static int boardReplyTotalPage()
	   {
		   SqlSession session=null;
		   int total=0;
		   try
		   {
			   session=ssf.openSession(true);// getConnection() : 미리 생성된 Connection주소 읽기 
			   total=session.selectOne("boardReplyTotalPage");
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection() ps.close(),conn.close() : 반환 
		   }
		   return total;
	   }
	   /*
	       SqlSession session=null;
		  
		   try
		   {
			   session=ssf.openSession(true);// getConnection() : 미리 생성된 Connection주소 읽기 
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection() ps.close(),conn.close() : 반환 
		   }
		   
	    */
	   /*
	    *   <select id="boardReplyAdminData" resultType="BoardReplyVO">
			    SELECT * FROM project_replyBoard
			    WHERE isreply!=1 AND group_step!=1
			  </select>
	    */
	   public static List<BoardReplyVO> boardReplyAdminData()
	   {
		   List<BoardReplyVO> list=null;
		   SqlSession session=null;
			  
		   try
		   {
			   session=ssf.openSession(true);// getConnection() : 미리 생성된 Connection주소 읽기 
			   list=session.selectList("boardReplyAdminData");
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection() ps.close(),conn.close() : 반환 
		   }
		   return list;
	   }
	   /*
	    *   <select id="boardReplyDetailData" resultType="BoardReplyVO" parameterType="int">
			    SELECT no,name,subject,content,hit,TO_CHAR(regdate,'YYYY-MM-DD') as dbday,group_id
			    FROM project_replyBoard
			    WHERE no=#{no}
			  </select>
	    */
	   public static BoardReplyVO boardReplyDetailData(int no)
	   {
		   BoardReplyVO vo=null;
		   SqlSession session=null;
			  
		   try
		   {
			   session=ssf.openSession();// getConnection() : 미리 생성된 Connection주소 읽기 
			   session.update("boardReplyHitDecrement",no);// 조회수 증가
			   session.commit();
			   vo=session.selectOne("boardReplyDetailData", no);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection() ps.close(),conn.close() : 반환 
		   }
		   return vo;
	   }
	   /*
	    *   <!--  어드민에서 답변 달기 -->
		  <select id="boardReplyInfoData" resultType="int" parameterType="int">
		    SELECT group_id FROM project_replyBoard 
		    WHERE no=#{no}
		  </select>
		  <insert id="boardReplyInsertOk" parameterType="BoardReplyVO">
		    <selectKey keyProperty="no" resultType="int" order="BEFORE">
		      SELECT NVL(MAX(no)+1,1) as no FROM project_replyBoard
		    </selectKey>
		    INSERT INTO project_replyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab)
		    VALUES(#{no},#{name},#{subject},#{content},#{pwd},
		     #{group_id},1,1
		    )
		  </insert>
		  <update id="boardReplyIsReply" parameterType="int">
		    UPDATE project_replyBoard SET
		    isreply=1
		    WHERE no=#{no}
		  </update>
	    */
	   public static void boardReplyInsertOk(int pno,BoardReplyVO vo)
	   {
		   SqlSession session=null;
			  
		   try
		   {
			   session=ssf.openSession();// getConnection() : 미리 생성된 Connection주소 읽기 
			   int gi=session.selectOne("boardReplyInfoData", pno);
			   vo.setGroup_id(gi);
			   session.insert("boardReplyInsertOk",vo);
			   session.update("boardReplyIsReply",pno);
			   session.commit();
		   }catch(Exception ex)
		   {
			   session.rollback();
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection() ps.close(),conn.close() : 반환 
		   }
	   }
	   
	   public static BoardReplyVO boardReplyUpdateData(int no)
	   {
		   BoardReplyVO vo=null;
		   SqlSession session=null;
			  
		   try
		   {
			   session=ssf.openSession();// getConnection() : 미리 생성된 Connection주소 읽기 
			   vo=session.selectOne("boardReplyDetailData", no);
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   if(session!=null)
				   session.close(); // disConnection() ps.close(),conn.close() : 반환 
		   }
		   return vo;
	   }
	   /*
	    *   <update id="boardReplyUpdate" parameterType="BoardReplyVO">
			    UPDATE project_replyBoard SET
			    name=#{name},subject=#{subject},content=#{content}
			    WHERE no=#{no}
			  </update>
	    */
	   public static void boardReplyUpdate(BoardReplyVO vo)
	   {
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession(true);
			   session.update("boardReplyUpdate",vo);
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
	   
	   /*
	    *   <select id="boardGetGroupId" resultType="int" parameterType="int">
			    SELECT group_id FROM project_replyBoard
			    WHERE no=#{no}
			  </select>
			  <delete id="boardDelete" parameterType="int">
			   DELETE FROM project_replyBoard
			   WHERE group_id=#{group_id}
			  </delete>
	    */
	   public static void boardDelete(int no)
	   {
		   SqlSession session=null;
		   try
		   {
			   session=ssf.openSession(true);
			   int gi=session.selectOne("boardGetGroupId", no);
			   session.delete("boardReplyDelete",gi);
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
}






