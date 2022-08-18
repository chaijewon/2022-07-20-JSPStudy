package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.*;
import com.sist.vo.*;
import com.sist.dao.*;
@Controller
public class ReserveModel {
    @RequestMapping("reserve/reserve.do")
    public String reserve_main(HttpServletRequest request,HttpServletResponse response)
    {
    	request.setAttribute("main_jsp", "../reserve/reserve.jsp");
    	return "../main/main.jsp";
    }
    // _ok.do , ajax 
    @RequestMapping("reserve/food_list.do")
    public String reserve_food_list(HttpServletRequest request,HttpServletResponse response)
    {
    	String type=request.getParameter("type");
    	if(type==null)
    		type="한식";
    	// 데이터 읽기 
    	List<FoodVO> list=ReserveDAO.reserveFoodData(type);
    	// 데이터 => 해당 JSP로 전송 
    	request.setAttribute("list", list);
    	return "../reserve/food_list.jsp";
    }
    
    // 달력 
    @RequestMapping("reserve/reserve_date.do")
    public String reserve_date(HttpServletRequest request,HttpServletResponse response)
    {
    	String fno=request.getParameter("fno");
    	String today=new SimpleDateFormat("yyyy-M-d").format(new Date());
    	StringTokenizer st=new StringTokenizer(today,"-");
    	String strYear=st.nextToken();
    	String strMonth=st.nextToken();
    	String strDay=st.nextToken();
    	
    	int year=Integer.parseInt(strYear);
    	int month=Integer.parseInt(strMonth);
    	int day=Integer.parseInt(strDay);
    	
    	Calendar cal=Calendar.getInstance();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month-1);
    	cal.set(Calendar.DATE, 1);
    	
    	int week=cal.get(Calendar.DAY_OF_WEEK);
    	int lastday=cal.getActualMaximum(Calendar.DATE);
    	
    	// DAO => 예약이 가능한 날 체크 
    	request.setAttribute("year", year);
    	request.setAttribute("month", month);
    	request.setAttribute("day", day);
    	request.setAttribute("week", week-1);
    	request.setAttribute("lastday", lastday);
    	String[] strWeek={"일","월","화","수","목","금","토"};
    	request.setAttribute("strWeek", strWeek);
    	
    	String rdays=ReserveDAO.reserveGetDate(Integer.parseInt(fno));
    	// 맛집에 대한 예약일을 가지고 온다 
    	StringTokenizer st1=new StringTokenizer(rdays,",");
    	int[] days=new int[32];
    	
    	while(st1.hasMoreTokens())
    	{
    		int d=Integer.parseInt(st1.nextToken());
    		if(d>=day) // 오늘 이후 
    		{
    		   days[d]=1;
    		}
    	}
    	// 0=> 예약이 없는 날 , 1=>예약이 있는 날 
    	request.setAttribute("days", days);
    	return "../reserve/reserve_date.jsp";
    }
    @RequestMapping("reserve/reserve_time.do")
    public String reserve_time(HttpServletRequest request,HttpServletResponse response)
    {
    	String day=request.getParameter("day");
    	// DAO ==> 시간대 읽기 
    	String times=ReserveDAO.reserveGetTime(Integer.parseInt(day));
    	List<String> list=new ArrayList<String>();
    	StringTokenizer st=new StringTokenizer(times,",");
    	while(st.hasMoreTokens())
    	{
    		int tno=Integer.parseInt(st.nextToken());
    		String time=ReserveDAO.reserveRealTime(tno);
    		list.add(time);
    	}
    	request.setAttribute("list", list);
    	return "../reserve/reserve_time.jsp";
    }
    @RequestMapping("reserve/reserve_inwon.do")
    public String reserve_inwon(HttpServletRequest request,HttpServletResponse response)
    {
    	return "../reserve/reserve_inwon.jsp";
    }
    
    @RequestMapping("reserve/reserve_ok.do")
    public String reserve_ok(HttpServletRequest request,HttpServletResponse response)
    {
    	try
    	{
    		request.setCharacterEncoding("UTF-8");
    	}catch(Exception ex){}
    	/*
    	 *              <input type="hidden" name=fno  id="re_fno">
                        <input type="hidden" name=rday id="re_rday">
                        <input type="hidden" name=rtime id="re_rtime">
                        <input type="hidden" name=inwon id="re_inwon">
                        
                        NO      NOT NULL NUMBER       
						ID               VARCHAR2(20) 
						FNO              NUMBER       
						RDAY    NOT NULL VARCHAR2(50) 
						RTIME   NOT NULL VARCHAR2(50) 
						INWON   NOT NULL VARCHAR2(30) 
						REGDATE          DATE         
						ISCHECK          CHAR(1)   
    	 */
    	String fno=request.getParameter("fno");
    	String rday=request.getParameter("rday");
    	String rtime=request.getParameter("rtime");
    	String inwon=request.getParameter("inwon");
    	
    	HttpSession session=request.getSession();
    	String id=(String)session.getAttribute("id");
    	
    	ReserveVO vo=new ReserveVO();
    	vo.setFno(Integer.parseInt(fno));
    	vo.setId(id);
    	vo.setRday(rday);
    	vo.setRtime(rtime);
    	vo.setInwon(inwon);
    	
    	ReserveDAO.reserveInsert(vo);
    	return "redirect:../mypage/mypage_reserve.do";
    }
    @RequestMapping("mypage/mypage_reserve.do")
    public String mypage_reserve(HttpServletRequest request,HttpServletResponse response)
    {
    	HttpSession session=request.getSession();
    	String id=(String)session.getAttribute("id");
    	List<ReserveVO> list=ReserveDAO.reserveMypageData(id);
    	request.setAttribute("list", list);
    	request.setAttribute("mypage_jsp", "../mypage/mypage_reserve.jsp");
    	request.setAttribute("main_jsp", "../mypage/mypage.jsp");
    	return "../main/main.jsp";
    }
    @RequestMapping("adminpage/adminpage_reserve.do")
    public String adminpage_reserve(HttpServletRequest request,HttpServletResponse response)
    {
    	List<ReserveVO> list=ReserveDAO.reserveAdminpageData();
    	request.setAttribute("list", list);
    	request.setAttribute("admin_jsp", "../adminpage/admin_reserve.jsp");
    	request.setAttribute("main_jsp", "../adminpage/adminpage.jsp");
    	return "../main/main.jsp";
    }
    @RequestMapping("adminpage/reserve_ok.do")
    public String adminpage_reserve_ok(HttpServletRequest request,HttpServletResponse response)
    {
    	String no=request.getParameter("no");
    	ReserveDAO.reserveAdminUpdate(Integer.parseInt(no));
    	return "redirect:../adminpage/adminpage_reserve.do";
    }
}








