package com.sist.controller;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
// @RequestMapping("list.do")
@Retention(RUNTIME)
@Target(METHOD)
public @interface RequestMapping {
   public String value();
}
