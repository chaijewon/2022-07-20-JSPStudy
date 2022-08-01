package com.sist.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.sist.dao.*;
public class SeoulMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SeoulMain sm=new SeoulMain();
        //sm.seoulAttractions();
        sm.seoulNature();
        //sm.seoulHotel();
        //sm.seoulGuest();
        //sm.seoulShop();
	}
	
	public void seoulAttractions()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=35;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/attractions?curPage="+i).get();
			   Elements poster=doc.select("ul.article-list li.item div.thumb");
			   Elements comment=doc.select("ul.article-list li.item div.infor-element span.text-dot-d");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			   for(int j=0;j<poster.size();j++)
			   {
				   try{
					   System.out.println("번호:"+k);
					   System.out.println(title.get(j).text());
					   System.out.println(poster.get(j).attr("style"));
					   System.out.println(comment.get(j).text());
					   System.out.println(link.get(j).attr("href"));
					   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
					   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
					   System.out.println("주소:"+address.text());
					   System.out.println("=========================================================");
				       
					   SeoulLocationVO vo=new SeoulLocationVO();
					   vo.setNo(k);
					   vo.setTitle(title.get(j).text());
					   vo.setMsg(comment.get(j).text());
					   String image=poster.get(j).attr("style");
					   image=image.substring(image.indexOf("(")+1,image.lastIndexOf(")"));
					   // style="background-image:url(/comm/getImage?srvcId=POST&amp;parentSn=5548&amp;fileTy=POSTTHUMB&amp;fileNo=1&amp;thumbTy=M)"
					   image="https://korean.visitseoul.net"+image;
					   vo.setPoster(image);
					   vo.setAddress(address.text());
					   dao.seoulLocationInsert(vo);
					   k++;
				   }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}
	
	public void seoulHotel()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=33;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/hotels?curPage="+i).get();
			   Elements poster=doc.select("ul.article-list li.item div.thumb img");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			
			   
			   for(int j=0;j<poster.size();j++)
			   {
				   try {
						   System.out.println("번호:"+k);
						   System.out.println(title.get(j).text());
						   System.out.println(poster.get(j).attr("src"));
						   System.out.println(link.get(j).attr("href"));
						  
						   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
						   Element address=doc2.select("div.detail-map-infor dl dd").get(0);
						   
						   System.out.println("주소:"+address.text());
						   
						   System.out.println("=========================================================");
					       SeoulHotelVO vo=new SeoulHotelVO();
					       vo.setNo(k);
					       vo.setName(title.get(j).text());
					       vo.setAddress(address.text());
					       vo.setPoster(poster.get(j).attr("src"));
					       
					     
					       dao.seoulHotelInsert(vo);
						   k++;
				   }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}
	/*
	 *  NO      NOT NULL NUMBER         
		TITLE   NOT NULL VARCHAR2(200)  
		POSTER  NOT NULL VARCHAR2(300)  
		MSG     NOT NULL VARCHAR2(4000) 
		ADDRESS NOT NULL VARCHAR2(300)
	 */
	public void seoulNature()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=14;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/nature?curPage="+i).get();
			   
			   Elements poster=doc.select("ul.article-list li.item div.thumb");
			   Elements comment=doc.select("ul.article-list li.item div.infor-element span.text-dot-d");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			   for(int j=0;j<poster.size();j++)
			   {
				  try
				  {
				   System.out.println("번호:"+k);
				   System.out.println(title.get(j).text());
				   System.out.println(poster.get(j).attr("style"));
				   System.out.println(comment.get(j).text());
				   System.out.println(link.get(j).attr("href"));
				   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
				   /*
				    *   <div class="detail-map-infor"> :eq(0)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(1)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(2)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    */
				   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
				   System.out.println("주소:"+address.text());
				   System.out.println("=========================================================");
			       SeoulNatureVO vo=new SeoulNatureVO();
			       vo.setNo(k);
			       vo.setTitle(title.get(j).text());
			       vo.setAddress(address.text());
			       vo.setMsg(comment.get(j).text());
			       String s=poster.get(j).attr("style");
			       s=s.substring(s.indexOf("(")+1,s.lastIndexOf(")"));
			       s="https://korean.visitseoul.net"+s;
			       vo.setPoster(s);
			       dao.seoulNatureInsert(vo);
				   k++;
				  }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}
	
	public void seoulGuest()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=28;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/seoul-stay?curPage="+i).get();
			   Elements poster=doc.select("ul.article-list li.item div.thumb img");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			
			   
			   for(int j=0;j<poster.size();j++)
			   {
				   try {
						   System.out.println("번호:"+k);
						   System.out.println(title.get(j).text());
						   System.out.println(poster.get(j).attr("src"));
						   System.out.println(link.get(j).attr("href"));
						  
						   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
						   Element address=doc2.select("div.detail-map-infor dl dd").get(0);
						   
						   System.out.println("주소:"+address.text());
						   
						   System.out.println("=========================================================");
					       SeoulHotelVO vo=new SeoulHotelVO();
					       vo.setNo(k);
					       vo.setName(title.get(j).text());
					       vo.setAddress(address.text());
					       vo.setPoster(poster.get(j).attr("src"));
					       
					     
					       dao.seoulGuestInsert(vo);
						   k++;
				   }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}
	
	public void seoulShop()
	{
		DataDAO dao=new DataDAO();
		try
		{
			int k=1;
			for(int i=1;i<=19;i++)
			{
			   Document doc=Jsoup.connect("https://korean.visitseoul.net/shopping?curPage="+i).get();
			   
			   Elements poster=doc.select("ul.article-list li.item div.thumb");
			   Elements comment=doc.select("ul.article-list li.item div.infor-element span.text-dot-d");
			   Elements link=doc.select("ul.article-list li.item a");
			   Elements title=doc.select("ul.article-list li.item div.infor-element span.title");
			   for(int j=0;j<poster.size();j++)
			   {
				  try
				  {
				   System.out.println("번호:"+k);
				   System.out.println(title.get(j).text());
				   System.out.println(poster.get(j).attr("style"));
				   System.out.println(comment.get(j).text());
				   System.out.println(link.get(j).attr("href"));
				   Document doc2=Jsoup.connect("https://korean.visitseoul.net"+link.get(j).attr("href")).get();
				   /*
				    *   <div class="detail-map-infor"> :eq(0)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(1)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    *   <div class="detail-map-infor"> :eq(2)
				    *     <dl>
				    *     </dl>
				    *   </div>
				    */
				   Element address=doc2.select("div.detail-map-infor:eq(1) dl dd").get(0);
				   System.out.println("주소:"+address.text());
				   System.out.println("=========================================================");
			       SeoulLocationVO vo=new SeoulLocationVO();
			       vo.setNo(k);
			       vo.setTitle(title.get(j).text());
			       vo.setAddress(address.text());
			       vo.setMsg(comment.get(j).text());
			       String s=poster.get(j).attr("style");
			       s=s.substring(s.indexOf("(")+1,s.lastIndexOf(")"));
			       s="https://korean.visitseoul.net"+s;
			       vo.setPoster(s);
			       dao.seoulShopInsert(vo);
				   k++;
				  }catch(Exception ex) {}
			   }
			}
		}catch(Exception ex){}
	}

}
