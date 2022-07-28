package com.sist.dao;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        List<MyBoardVO> list=MyBoardDAO.boardListData();
        for(MyBoardVO vo:list)
        {
        	System.out.println(vo.getNo());
        	System.out.println(vo.getName());
        	System.out.println(vo.getSubject());
        	System.out.println(vo.getContent());
        	System.out.println("----------------------------");
        }
	}

}
