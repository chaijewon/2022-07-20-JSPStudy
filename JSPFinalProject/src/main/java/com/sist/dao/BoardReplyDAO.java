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
}






