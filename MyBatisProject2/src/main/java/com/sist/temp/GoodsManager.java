package com.sist.temp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GoodsManager {
   public static void main(String[] args) {
	    GoodsManager gm=new GoodsManager();
	    gm.goodsData();
   }
   /*
    *   GOODS_NAME        NOT NULL VARCHAR2(1000) 
		GOODS_SUB                  VARCHAR2(1000) 
		GOODS_PRICE       NOT NULL VARCHAR2(50)   
		GOODS_DISCOUNT             NUMBER         
		GOODS_FIRST_PRICE          VARCHAR2(20)   
		GOODS_DELIVERY    NOT NULL VARCHAR2(20)
    */
   public void goodsData()
   {
	   GoodsDAO dao=new GoodsDAO();
	   try
	   {
		  for(int p=1;p<=258;p++)
		  {
		   Document doc=Jsoup.connect("https://shop.10000recipe.com/index.php?path=category&sort=popular&page="+p).get();
		   Elements link=doc.select("div.s_list_wrap_vt ul.common2_sp_list_ul li.common2_sp_list_li a");
		   for(int i=0;i<link.size();i++)
		   {
			  try
			  {
			   System.out.println(link.get(i).attr("href"));
			   String path=link.get(i).attr("href");
			   Document doc2=Jsoup.connect(path).get();
			   GoodsVO vo=new GoodsVO();
			   Element name=doc2.selectFirst("div.s_view_info h3 p");
			   vo.setGoods_name(name.text());
			   Element sub=null;
			   try
			   {
			     sub=doc2.selectFirst("div.sub_info");
			     vo.setGoods_sub(sub.text());
			   }catch(Exception ex){
				   vo.setGoods_sub("no");
			   }
			   Element price=doc2.selectFirst("div.price_box p.price");
			   vo.setGoods_price(price.text());
			   Element discount=doc2.selectFirst("div.price_box p.dc");
			   vo.setGoods_discount(Integer.parseInt(discount.text().replace("%", "").trim()));
			   Element first_price=doc2.selectFirst("div.price_sale p.price_sale_p");
			   vo.setGoods_first_price(first_price.text());
			   //Element delivery=doc2.selectFirst("div.info_delivery_area dl.info_delivery");
			   vo.setGoods_delivery("무료배송");
			   Element poster=doc2.selectFirst("div.s_view_pic_zoom a#mainImage img");
			   vo.setGoods_poster(poster.attr("src"));
			   System.out.println(name.text());
			   System.out.println(sub.text());
			   System.out.println(price.text());
			   System.out.println(discount.text());
			   System.out.println(first_price.text());
			   System.out.println("무료배송");
			   System.out.println(poster.attr("src"));
			   System.out.println("================================");
			   
			   dao.goodsAllInsert(vo);
			  }catch(Exception ex){}
		   }
		   System.out.println("저장 완료!!");
		  }
	   }catch(Exception ex){ex.printStackTrace();}
   }
}
