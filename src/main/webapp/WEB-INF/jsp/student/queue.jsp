<%--
  Created by IntelliJ IDEA.
  User: 云淡风轻
  Date: 2018/5/20
  Time: 16:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <title>queue</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="jumbotron">
                <h1>您好！</h1>
                <p>该实验目前尚未有资源空闲，预计10分钟后可进行实验，请选择预约实验或者继续等待</p>
                </p>
            </div>
            <div class="panel panel-default">
                <div class="panel-body">
                    <p class="text-center">
                        <button class="btn btn-default btn-info" onClick="location.href='/lab/labPre?id=${item.number}'">预约实验</button>
                        <button class="btn btn-default btn-info" onClick="location.href='/student/queue?id=${item.number}'">继续等待</button>
                        <!--弹出框-->
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>
<%--<div class="col-md-3" />
<div class="col-md-6">
        <div class="jumbotron">
            <h1>您好！</h1>
            <p>该实验目前尚未有资源空闲，预计10分钟后可进行实验，请选择预约实验或者继续等待</p>
        </div>
        <div class="panel panel-default">
            <div class="panel-body">
                <p class="text-center">
                    <button class="btn btn-default btn-xs btn-info" onClick="location.href='/lab/labPre?id=${item.number}'">预约实验</button>
                    <button class="btn btn-default btn-xs btn-info" onClick="location.href='/student/queue?id=${item.number}'">继续等待</button>
                    <!--弹出框-->
                </p>
            </div>
        </div>
    </div>
<div class="col-md-3" />--%>

</body>
</html>
