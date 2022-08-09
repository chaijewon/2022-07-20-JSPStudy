package com.sist.vo;
import java.util.*;
public class MainClass {
  public static void main(String[] args) {
	  Map map=new HashMap();
	  map.put("boardListData", "SELECT * FROM board");
	  map.put("boardDetailData", "SELECT * FROM board WHERE no=?");
	  System.out.println(map.get("boardListData"));
	  System.out.println(map.get("boardDetailData"));
  }
}
