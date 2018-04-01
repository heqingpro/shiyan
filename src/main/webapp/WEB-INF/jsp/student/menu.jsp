<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 String path = request.getContextPath();
 String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
   + path + "/";
%>
<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked" id="nav">
        <li><a href="<%=basePath%>student/showCourse">所有实验<span class="badge pull-right">26</span></a></li>
        <li><a href="<%=basePath%>student/selectedCourse">已预约实验<span class="badge pull-right">5</span></a></li>
        <li><a href="<%=basePath%>student/overCourse">完成实验<span class="badge pull-right">8</span></a></li>
        <li><a href="<%=basePath%>student/passwordRest">修改密码<sapn class="glyphicon glyphicon-pencil pull-right" /></a></li>
        <li><a href="<%=basePath%>logout">退出系统<sapn class="glyphicon glyphicon-log-out pull-right" /></a></li>
        <li class="disabled"><a href="##">Responsive</a></li>
    </ul>
</div>