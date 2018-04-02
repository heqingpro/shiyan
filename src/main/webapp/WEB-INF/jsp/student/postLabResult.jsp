<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/2
  Time: 14:47
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

<!DOCTYPE html>
<html>
<head>
    <title></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 顶栏 -->
<jsp:include page="top.jsp"></jsp:include>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">提交实验结果</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="<%=basePath%>/student/postLabResultInfo?"  method="post">
                        <div class="form-group ">
                            <label for="inputId" class="col-sm-2 control-label" >预约实验编号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="number" class="form-control" id="inputId" name="labpreId" placeholder="请输入"
                                <c:if test='${labPre!=null}'>
                                       value="${labPre.id}"
                                </c:if>>
                            </div>
                        </div>
                        <div class="form-group ">
                            <label for="inputNumber" class="col-sm-2 control-label" >学号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="number" class="form-control" id="inputNumber" name="stuNum" placeholder="请输入学号"
                                <c:if test='${labPre!=null}'>
                                       value="${labPre.stuNum}"
                                </c:if>>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputLabNum" class="col-sm-2 control-label">实验编号</label>
                            <div class="col-sm-10">
                                <input readonly="readonly" type="text" class="form-control" id="inputLabNum" name="labNum" placeholder="请输入实验编号" value="${labPre.labNum}">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputDescription" class="col-sm-2 control-label">实验结果描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputDescription" name="description" placeholder="请输入结果描述">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputOthers" class="col-sm-2 control-label">补充</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="inputOthers" name="others" placeholder="其他补充">
                            </div>
                        </div>
                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                            <button class="btn btn-default" type="reset">重置</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </div>
</div>
<div class="container" id="footer">
    <div class="row">
        <div class="col-md-12"></div>
    </div>
</div>
</body>
</html>