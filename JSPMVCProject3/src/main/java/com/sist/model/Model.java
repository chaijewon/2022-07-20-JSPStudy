package com.sist.model;

import javax.servlet.http.HttpServletRequest;

/*
 *   interface : 유사한 클래스를 모아서 한번에 관리 
 *   -------------------------------------
 */
public interface Model {
   public String execute(HttpServletRequest request);
}
