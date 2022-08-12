<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title>jQuery UI 프로그레스바 타이머</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<style type="text/css">
#progressbar1 {
  height: 23px;
  width: 400px;
}
#progressbar1 .ui-progressbar-value {
  margin-top: -23px;
}
#progressbar1 span.caption {
  display: block;
  text-align: center;
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script>
var total_time = 5000;
var current_time = 0;
var refresh_interval = 30;
var timer;
 
function refresh_bar() {
  if(current_time > total_time) {
    clearInterval( timer );
    current_time = total_time;
  }
  percentage = 100 * current_time / total_time;
  $( "#progressbar1" ).progressbar({ value: current_time })
    .children('span.caption').html(percentage.toFixed(1) + ' %');
  current_time += refresh_interval;
}

$(function() {
  $( "#progressbar1" ).progressbar({ max: total_time });
  refresh_bar();
  timer = setInterval( refresh_bar, refresh_interval );
});
</script>
</head>
<body>
 
<div id="progressbar1"><span class="caption"></span></div>
 
</body>
</html>