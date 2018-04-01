<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
    <%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<style>
    #back1{
      position:fixed;
	  width:100%;
	  height:100%;
	  border:0px solid #000000;
	  padding:0px;
     }
    #标题{
	position: absolute;
	top: 15%;
	left: 38%;
	text-align: center;
	color: #FFFBF0;
	font-size: 36px;
	font-style: normal;
	}
     #back2{
		position:absolute;
		top:30%;
		height:240px;
		width:100%;
		background-color: rgba(255,255,255,0.2);
	}
	#content{
		position:absolute;
		top:50%;
		left:50%;
		height:240px;
		margin-left:-100px;
		margin-top:-50px;
		border:0px solid #000000;
		padding:0px;
	}
  

</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
</head>


<body>
<div id="back1" style="background-image:url(背景001.png)"><img src="<%=basePath%>/picture/背景001.png" width=100% height=100% />
  <div id="标题">欢迎登录远程实验系统</div>
<div id="back2">
<div id="content">
<form action="${pageContext.request.contextPath }/student/login">

<table border="0" align="center" cellspacing="0" class="宋体"> 
<tr> 
<td width="50" align="center">学号：</td> 
<td><input type="text" name="number"></td> 
</tr>
<tr> 
<td width="50" align="center">密码：</td> 
<td><input type="text" name="password"></td> 
</tr> 

<tr> 
  <td width="50"></td>
  <td align="center"><input type="submit" value="登录"></td> 
</tr>
</table>
</form> 

 
</div>
</div>
</div>
</body>
</html>