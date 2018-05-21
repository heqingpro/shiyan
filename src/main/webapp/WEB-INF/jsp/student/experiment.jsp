<%--
  Created by IntelliJ IDEA.
  User: 云淡风轻
  Date: 2018/5/17
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>


<!DOCTYPE html>
<html>
<head>
    <title></title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="/js/jquery-3.2.1.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</head>

<body>
<!--导航栏部分-->
<%--<jsp:include page="include/header.jsp"/>--%>
<!-- 中间主体 -->
<div class="container" id="content">
    <div class="row">
        <%--             <jsp:include page="menu.jsp"></jsp:include>--%>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 style="text-align: center;">开始实验，请提交实验参数</h1>
                    </div>
                </div>
                <div class="panel-body">
                    <form class="form-horizontal" role="form" action="/student/experiment?id=${id}" id="editfrom" method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <div class="form-group">
                                <label class="col-sm-3 control-label">时间t</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="exp1" placeholder="请输入t" name="time">
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">样本</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="exp" placeholder="请输入样本" name="number">
                                </div>
                            </div>
                        </div>

                        <div class="form-group" style="text-align: center">
                            <button class="btn btn-default" type="submit">提交</button>
                        </div>
                    </form>
                </div>

            </div>

        </div>
    </div>
</div>
</body>


</html>


