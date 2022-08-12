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
  float: right;
}
#progressbar1 span.caption {
  display: block;
  text-align: center;
}
</style>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script>
function toMMSS(sec_num) {
  var minutes = Math.floor(sec_num / 60);
  var seconds = (sec_num - (minutes * 60)).toFixed(1);
  if ( minutes < 10 ) minutes = "0" + minutes;
  if ( seconds < 10 ) seconds = "0" + seconds;
  return minutes+':'+seconds;
}

function refresh_bar() {
  if(remained_time < 0) {
    clearInterval( timer );
    remained_time = 0;
  }
  remain_time = toMMSS( remained_time / 1000 );
  $( "#progressbar1" ).progressbar({ value: remained_time })
    .children("span.caption").html( remain_time );
  remained_time -= refresh_interval;
}

var total_time = 600000;
var remained_time = total_time;
var refresh_interval = 100;
var timer;

$(function() {
  $( "#progressbar1" ).progressbar({ max: total_time, value: total_time });
  refresh_bar();
  timer = setInterval( refresh_bar, refresh_interval );
});
</script>
</head>
<body>
 
<div id="progressbar1"><span class="caption"></span></div>
 
</body>
</html>