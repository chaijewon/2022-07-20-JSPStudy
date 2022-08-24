package com.sist.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.controller.Controller;
import com.sist.controller.RequestMapping;
import com.sist.manager.WeatherManager;

@Controller
public class WeatherModel {
  @RequestMapping("weather/weather.do")
  public String weather_list(HttpServletRequest request,HttpServletResponse response)
  {
	  WeatherManager wm=new WeatherManager();
	  String w=wm.seoulWeather();
	  request.setAttribute("data", w);
	  request.setAttribute("main_jsp", "../weather/weather.jsp");
	  return "../main/main.jsp";
  }
}
