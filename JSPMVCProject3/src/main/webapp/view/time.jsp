<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
</head>
<script language="JavaScript">
<!--  
function clock() {
   var time = new Date()
       
   var hour = time.getHours()
   var minute = time.getMinutes()
   var second = time.getSeconds()
   var store = " "  
       
   store += ((hour > 12) ? (hour - 12) : hour)
   store += ((minute < 10) ? ":0" : ":") + minute
   store += ((second < 10) ? ":0" : ":") + second
   store += (hour >= 12) ? " P.M" : " A.M"
       
   document.time.clock.value = store  
   setTimeout("clock()", 1000)
}
//-->
function ipchal()
{
	if(frm5.ipcp.value=="")
	{
		alert("입찰가를 입력하세요");
		frm5.ipcp.focus();
	}
	else if (isNaN(frm5.ipcp.value)!=0)
	{
		alert("입찰가를 숫자로 입력하세요");
		frm5.ipcp.select();
	}
	else if (frm5.ipcp.value<=frm5.nowp.value)
	{
		alert("입찰가가 현재가보다 낮습니다.");
		frm5.ipcp.select();
	}
	else
	{
		alert("[입찰가] : "+frm5.ipcp.value+" 입찰되셨습니다.");
		frm5.nowp.value=frm5.ipcp.value;
		frm5.nowp.disabled=true;

	}
}

</script>
</head>
<body onLoad="clock()">
   <form name="time">
       <input name="clock" size="12" value="" style="border:0">
   </form>
   <form name="frm5">
	[상품명] LG노트북<br>
	[시장가] 560,000원<br>
	[현재가]<input type="text" name="nowp" value="450000"><br>
	[입찰가]<input type="text" name="ipcp"><br>
	<input type="button" value="입찰" onclick="ipchal()">
	<input type="button" value="취소" onclick="reset()">
	</form>
   
   
</body>
</html>