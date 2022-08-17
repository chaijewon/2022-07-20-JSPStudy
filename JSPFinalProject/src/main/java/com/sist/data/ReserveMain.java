package com.sist.data;
import java.util.*;
public class ReserveMain {
   public static void main(String[] args) {
	   ReserveDAO dao=new ReserveDAO();
	   /*for(int i=1;i<=31;i++)
	   {
		   String s=getRand();
		   dao.reserveDay(i, s);
	   }*/
	   List<Integer> list=dao.foodGetFno();
	   for(int fno:list)
	   {
		   String s=getRand();
		   dao.reserveDays(fno, s);
	   }
	   System.out.println("저장 완료");
   }
   public static String getRand()
   {
	   String result="";
	   int[] rand=new int[(int)(Math.random()*6)+10];
	   int su=0;
	   boolean bCheck=false;
	   for(int i=0;i<rand.length;i++)
	   {
		   bCheck=true;
		   while(bCheck)
		   {
			   su=(int)(Math.random()*31)+1;
			   bCheck=false;
			   for(int j=0;j<i;j++)
			   {
				   if(rand[j]==su)//중복 
				   {
					   bCheck=true;
					   break;
				   }
			   }
		   }
		   rand[i]=su;
		   //result+=su+",";
	   }
	   
	   // 정렬
	   for(int i=0;i<rand.length-1;i++)
	   {
		   for(int j=i+1;j<rand.length;j++)
		   {
			   if(rand[i]>rand[j])
			   {
				   int temp=rand[i];
				   rand[i]=rand[j];
				   rand[j]=temp;
			   }
		   }
	   }
	   
	   for(int i=0;i<rand.length;i++)
	   {
		   result+=rand[i]+",";
	   }
	   result=result.substring(0,result.lastIndexOf(","));
	   return result;
   }
}





