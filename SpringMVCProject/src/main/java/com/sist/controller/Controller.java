package com.sist.controller;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
// @Controller ==> Model
@Retention(RUNTIME)
@Target(TYPE)
public @interface Controller {

}
