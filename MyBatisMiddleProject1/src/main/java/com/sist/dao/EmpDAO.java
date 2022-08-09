package com.sist.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.util.*;
public class EmpDAO {
  
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
	    *     <select id="empDeptJoinData" resultType="com.sist.dao.EmpVO">
	 		    SELECT empno,ename,job,hiredate,sal,emp.deptno,dname,loc
	 		    FROM emp,dept
	 		    WHERE emp.deptno=dept.deptno
	 		  </select>
	    */
	   public static List<EmpVO> empDeptJoinData()
	   {
		   SqlSession session=ssf.openSession();
		   List<EmpVO> list=session.selectList("empDeptJoinData");
		   session.close();
		   return list;
	   }
	   /*<select id="empDeptDetailData" resultMap="empMap" parameterType="int">
	    <include refid="join-sql"/>
	    AND empno=#{empno}
	  </select>*/
	   public static EmpVO empDeptDetailData(int empno)
	   {
		   SqlSession session=ssf.openSession();
		   EmpVO list=session.selectOne("empDeptDetailData",empno);
		   session.close();
		   return list;
	   }
	   /*
	    *  <select id="empGetEnameData" resultType="string">
		    SELECT ename FROM emp
		  </select>
	    */
	   public static List<String> empGetEnameData()
	   {
		   SqlSession session=ssf.openSession();
		   List<String> list=session.selectList("empGetEnameData");
		   session.close();
		   return list;
	   }
	   
	   /*
	    *  <select id="empFindData" resultType="com.sist.dao.EmpVO" parameterType="hashmap">
		    <include refid="join-sql"/>
		    AND ename
		    <trim prefix="IN">
		      <foreach collection="nameArr" item="name" open="(" close=")" separator=",">#{name}</foreach>
		    </trim>
		  </select>
	    */
	   public static List<EmpVO> empFindData(Map map)
	   {
		   SqlSession session=ssf.openSession();
		   List<EmpVO> list=session.selectList("empFindData",map);
		   session.close();
		   return list;
	   }
}
