<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
    <%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<style>
  body{
	  margin:opx;
	  text-align:center;
	  }
  #container{
	position: absolute;
	width: 100%;
	height: 100%;
	margin: 0px;
	border: 0px none #FFFFFF;
	padding: 0px;
	background-image: url("<%=basePath%>/picture/背景001.png");
	background-repeat: no-repeat;
	background-position: 100% 100%;
	background-attachment: fixed;
	font-family: "宋体";
	font-size: 36px;
	font-style: normal;
	color: rgba(255,255,255,1);
  }
  #banner{
	margin-bottom: 5px;
	padding: 0px;
	  background-color;#a2d9ff;
	border: 0px solid #000000;
	text-align: center;
	height: 8%;
  }
  #links{
	float: left;
	width: 20%;
	height: 600px;
	border: 0px solid #000000;
	text-align: center;
	background-color: rgba(255,255,255,0.5);
	top: auto;
	position: static;
  }
  #content{
	float: right;
	width: 80%;
	height: 600px;
	border: 0px solid #000000;
	text-slign: center;
	background-color: rgba(255,255,255,0.2);
	position: static;
	top: auto;
  }
  #footer{
	  clear:both;
	  padding:0px;
	  border:0px solid #000000;
	  text-align:center;
  }
</style>

<title>远程实验系统</title>
</head>

<body>
<div id="container"> 远程数字实验管理系统
<div id="banner">
    <div align="right">     <a href="login.jsp">登录</a>     <a href="regist.jsp">注册</a>    </div>
  </div>
     <div id="links"><table align=center width="200" border="0">
                          <tr>
                             <td>预约实验</td>
                          </tr>
                          <tr>
                             <td>开始实验</td>
                          </tr>
                          <tr>
                             <td>成绩查询</td>
                          </tr>
                          </table>
</div>
     <div id="content">content</div>
     <div id="footer">footer</div>
</div>
</body>
</html>