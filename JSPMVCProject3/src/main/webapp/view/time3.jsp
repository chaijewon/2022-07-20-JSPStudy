<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>

<style>
#progressbar1 {
  height: 23px;
}
#progressbar1 .ui-progressbar-value {
  margin-top: -23px;
}
#progressbar1 span.caption {
  display: block;
  text-align: center;
}
</style>
<script>
function toMMSS(sec_num) {
  var minutes = Math.floor(sec_num / 60);
  var seconds = (sec_num - (minutes * 60)).toFixed(1);
  if ( minutes < 10 ) minutes = "0" + minutes;
  if ( seconds < 10 ) seconds = "0" + seconds;
  return minutes+':'+seconds;
}
 
function refresh_bar() {
  if(current_time > total_time) {
    clearInterval( timer );
    current_time = total_time;
  }
  remain_time = toMMSS( (total_time - current_time)/1000 );
  $( "#progressbar1" ).progressbar({ value: current_time })
    .children('span.caption').html( remain_time );
  current_time += refresh_interval;
}
 
var total_time = 6000;
var current_time = 0;
var refresh_interval = 100;
var timer;
 
$(function() {
  $( "#progressbar1" ).progressbar({ max: total_time });
  refresh_bar();
  timer = setInterval( refresh_bar, refresh_interval );
});
</script>
 
<div id="progressbar1"><span class="caption"></span></div>