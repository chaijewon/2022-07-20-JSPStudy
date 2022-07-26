package com.sist.main;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sist.dao.*;
import java.util.*;
/*
 *     <div class="a">
 *       <a href="">aaaa</a>
 *       <span class="b"></span>
 *     </div>
 *     <a href=""></a>
 *     
 *     select("div.a a") select(span.b) => class / id 
 *                                         =====
 *                                         태그명.클래스명  / 태그명#아이디명
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass mc=new MainClass();
		mc.movieData();
	}
	// 영화
	/*
	 *   <div class="lst_wrap">
				<ul class="lst_detail_t1">
				<li>
					<div class="thumb">
	<a href="/movie/bi/mi/basic.naver?code=187348"><img src="https://movie-phinf.pstatic.net/20210825_8/1629879510900xEwsL_JPEG/movie_image.jpg?type=m99_141_2" alt="샹치와 텐 링즈의 전설" onerror="this.src='https://ssl.pstatic.net/static/movie/2012/09/dft_img99x141.png'"></a><!-- N=a:nol.img,r:1,i:187348 -->
	</div>
    <dl class="lst_dsc">
					<dt class="tit">
	<span class="ico_rating_12">12세 관람가</span> => icon
<a href="/movie/bi/mi/basic.naver?code=187348">샹치와 텐 링즈의 전설</a>
						<!-- N=a:nol.title,r:1,i:187348 -->
					</dt>
					<dd class="star">
			<dl class="info_star">
									<dt class="tit_t1">네티즌</dt>
									<dd>
										<div class="star_t1">
											<a href="/movie/bi/mi/point.naver?code=187348#pointAfterTab"><span class="st_off"><span class="st_on" style="width:68.6%"></span></span><span class="num">6.86</span><span class="num2">참여 <em>4,293</em>명</span></a><!-- N=a:nol.urating -->
										</div>
	
											<span class="split">|</span>
										
									</dd>
									
									
								</dl>
<dl class="info_exp">
												<dt class="tit_t1">예매율</dt>
												<dd>
													<div class="star_t1 b_star">
													
														
															<span class="num">42.58</span><span class="txt">%</span>
														
														
													
													</div>
												</dd>
											</dl>
										
									
									
									
								
							
							
							
							
							
							
						
						
					</dd>
					<dd>
						<dl class="info_txt1">
						<dt class="tit_t1">개요</dt>
						<dd>
							
							<span class="link_txt">
								
									<a href="/movie/sdb/browsing/bmovie.naver?genre=19">액션</a><!-- N=a:nol.genre,r:1 -->, 
								
									<a href="/movie/sdb/browsing/bmovie.naver?genre=6">모험</a><!-- N=a:nol.genre,r:2 -->, 
								
									<a href="/movie/sdb/browsing/bmovie.naver?genre=2">판타지</a><!-- N=a:nol.genre,r:3 -->
								
							</span>

								<span class="split">|</span>
								132분
							

							
							
								
								<span class="split">|</span>
								2021.09.01 개봉
							
						</dd>
						
						
						<dt class="tit_t2">감독</dt>
						<dd>
							<span class="link_txt">
								
									<a href="/movie/bi/pi/basic.naver?code=165141">데스틴 크리튼</a><!-- N=a:nol.director,r:1 -->
								
							</span>
						</dd>
						
						
						
						<dt class="tit_t3">출연</dt>
						<dd>
							<span class="link_txt">
								
									<a href="/movie/bi/pi/basic.naver?code=379111">시무 리우</a><!-- N=a:nol.actor,r:1 -->, 
								
									<a href="/movie/bi/pi/basic.naver?code=1850">양조위</a><!-- N=a:nol.actor,r:2 -->, 
								
									<a href="/movie/bi/pi/basic.naver?code=391433">아콰피나</a><!-- N=a:nol.actor,r:3 -->, 
								
									<a href="/movie/bi/pi/basic.naver?code=441045">장멍</a><!-- N=a:nol.actor,r:4 -->, 
								
									<a href="/movie/bi/pi/basic.naver?code=1849">양자경</a><!-- N=a:nol.actor,r:5 -->, 
								
									<a href="/movie/bi/pi/basic.naver?code=441046">로니 쳉</a><!-- N=a:nol.actor,r:6 -->, 
								
									<a href="/movie/bi/pi/basic.naver?code=207151">진법랍</a><!-- N=a:nol.actor,r:7 -->, 
								
									<a href="/movie/bi/pi/basic.naver?code=425934">플로리안 문테아누</a><!-- N=a:nol.actor,r:8 -->
								
							</span>
						</dd>
						
						
						</dl>
					</dd>
	 */
	public void movieData()
	{
		DataDAO dao=DataDAO.newInstance();// newInstance() , getInstance()
		// new => new갯수만큼 메모리가 생성 , 한개의 메모리만 사용이 가능하게 만들어 준다 (메모리 누수방지)
		try
		{
			
			Document doc=Jsoup.connect("https://movie.naver.com/movie/running/premovie.naver").get();
		    // 출력된 HTML을 가지고 있다 (doc)
			int k=93; // mno 
		    int c=2; // cno => 1상영/2개봉/3전체영화
		    Elements title=doc.select("dt.tit a"); // select(css)
		    Elements grade=doc.select("dt.tit span");
		    Elements reserve=doc.select("span.num");
		    Elements etc=doc.select("dl.info_txt1 dt.tit_t1+dd");
		    Elements director=doc.select("dl.info_txt1 dt.tit_t2+dd");
		    Elements actor=doc.select("dl.info_txt1 dt.tit_t3+dd");
		    Elements poster=doc.select("div.thumb img");
		    Elements link=doc.select("div.thumb a");
		    // 인접 (옆에 있는 태그) + ~
		    for(int i=0;i<116;i++)
		    {
		    	MovieVO vo=new MovieVO();
		    	try
		    	{
		    	  System.out.println((i+1)+"."+title.get(i).text());
		    	  vo.setMno(k);
		    	  vo.setCno(c);
		    	  String ss="";
		    	  try
		    	  {
		    		  ss=title.get(i).text();
		    	  }catch(Exception ex)
		    	  {
		    		  ss="";
		    	  }
		    	  vo.setTitle(ss);
		    	  try
		    	  {
		    	     System.out.println(grade.get(i).text());
		    	     vo.setGrade(grade.get(i).text());
		    	  }catch(Exception ex)
		    	  {
		    		  System.out.println("등급없음");
		    		  vo.setGrade("등급없음");
		    	  }
		    	  
		    	  try
		    	  {
		    	     ss=reserve.get(i).text();
		    	  }catch(Exception ex)
		    	  {
		    		  ss="";
		    	  }
		    	  vo.setReserve(ss);
		    	  
		    	  //System.out.println(etc.get(i).text());
		    	  // 공포, 스릴러 | 72분 | 2021.08.26 개봉
		    	  
		    	  StringTokenizer st=new StringTokenizer(etc.get(i).text(),"|");
		    	  String genre=st.nextToken();
		    	  String time=st.nextToken();
		    	  String regdate=st.nextToken();
		    	  System.out.println(genre.trim());
		    	  vo.setGenre(genre);
		    	  System.out.println(time.trim());
		    	  vo.setTime(time);
		    	  System.out.println(regdate.trim());
		    	  vo.setRegdate(regdate);
		    	  try
		    	  {
		    	     ss=director.get(i).text();
		    	  }catch(Exception ex)
		    	  {
		    		  ss="";
		    	  }
		    	  vo.setDirector(ss);
		    	  try
		    	  {
		    	     ss=actor.get(i).text();
		    	  }catch(Exception ex)
		    	  {
		    		  ss="";
		    	  }
		    	  vo.setActor(ss);
		    	  System.out.println(poster.get(i).attr("src"));
		    	  vo.setPoster(poster.get(i).attr("src"));
		    	  String strLink="https://movie.naver.com"+link.get(i).attr("href");// 줄거리 
		    	  Document doc2=Jsoup.connect(strLink).get();
		    	  Element story=doc2.selectFirst("p.con_tx");
		    	  System.out.println(story.text());
		    	  // <span class="count">754,989명
		    	  String s="";
		    	  try
		    	  {
		    	     Element showUser=doc2.selectFirst("span.count");
		    	     s=showUser.text().substring(0,showUser.text().indexOf("("));
		    	  }catch(Exception ex)
		    	  {
		    		  s="0명";
		    	  }
		    	  vo.setShowUser(s);
		    	  System.out.println("관객:"+s);
		    	  try
		    	  {
			    	  Element score=doc2.selectFirst("span.st_on"); // span class="st_on
			    	  s=score.text();
			    	  s=s.replaceAll("[가-힣]", "");
			    	  //  7.64
			    	  System.out.println("평점:"+s.trim());
			    	  vo.setScore(Double.parseDouble(s));
		    	  }catch(Exception ex)
		    	  {
		    		  s="0.0";
		    		  vo.setScore(Double.parseDouble(s));
		    	  }
		    	  
		    	  //System.out.println(youtubeGetKey(title.get(i).text()));
		    	  vo.setKey(youtubeGetKey(title.get(i).text()));
		    	  System.out.println(vo.getShowUser());
		    	  dao.movieInsert(vo);
		    	  System.out.println("=========================================");
		    	  
		    	  k++;
		    	}catch(Exception ex) {} // for을 다시 수행(증가)
		    	// <a href="aaa">bbb</a>
		    	/*
		    	 *   1. aaa ==> attr("속성명") => img(src),a(href)
		    	 *   2. bbb ==> text()
		    	 *   3. html() 
		    	 *   <div>
		    	 *     <span>aaa</span>
		    	 *   </div>
		    	 *   
		    	 *   => text() => aaa
		    	 *   => html() => <span>aaa</span>
		    	 *   => javascript안에 있는 값을 읽을 경우 => data()
		    	 */
		    }
		}catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	public String youtubeGetKey(String title)
	{
		String key="";
		try
		{
			Document doc=Jsoup.connect("https://www.youtube.com/results?search_query="+title).get();
			Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
			// /watch?v=(숫자,알파벳,특수문자) +(여러개문자를 읽어 올때)
			Matcher m=p.matcher(doc.toString());
			// /watch?v=47JjBTbI6P0"
			while(m.find())// 시작하는 문자열을 찾은 경우 
			{
				String s=m.group();//찾은 문장을 읽어 온다 
				key=s.substring(s.indexOf("=")+1,s.indexOf("\""));
				break;
			}
		}catch(Exception ex){}
		return key;
	}
	// 맛집 
	// 레시피
	// 행사 / 호텔 / 이벤트 

}
