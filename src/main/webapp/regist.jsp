<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
  <%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<head>
<style>
    #back1{
	position: fixed;
	width: 100%;
	height: 100%;
	margin: 0px;
	border: 0px solid #000000;
	padding: 0px;
	background-attachment: fixed;
	background-image: url("<%=basePath%>/picture/背景001.png");
	background-repeat: no-repeat;
	background-position: 100% 100%;
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
		left:49%;
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
<div id="back1" >
  <div id="标题">欢迎注册远程实验系统</div>
<div id="back2">
<div id="content">
<form action="${pageContext.request.contextPath }/student/regist"> 
<table border="0" align="center" cellspacing="0" class="宋体"> 
  <tr> 
<td align="center">姓名</td> 
<td><input type="text" name="name"></td> 
</tr> 
<tr> 
<td align="center">密码</td> 
<td><input type="text" name="password"></td> 
</tr> 
<tr> 
<td align="center">学号</td> 
<td><input type="text" name="number"></td> 
</tr> 
<tr> 
<td align="center">学校</td> 
<td><input type="text" name="school"></td> 
</tr>
<tr> 
  <td></td>
  <td align="center"><input type="submit" value="注册"></td> 
</tr>
</table>
</form> 

</div>
</div>

</div>
</body>
</html>