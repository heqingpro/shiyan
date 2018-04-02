<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/2
  Time: 8:46
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
    <title>教师信息显示</title>

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 引入bootstrap -->
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.min.css">
    <!-- 引入JQuery  bootstrap.js-->
    <script src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js"></script>

    <%--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">--%>

</head>
<body>
<!-- 顶栏 -->

<!-- 中间主体 --><jsp:include page="top.jsp"></jsp:include>
<div class="container" id="content">
    <div class="row">
        <jsp:include page="menu.jsp"></jsp:include>
        <div class="col-md-10">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <h1 class="col-md-5">实验管理</h1>
                        <form class="bs-example bs-example-form col-md-5" role="form" style="margin: 20px 0 10px 0;" action="/admin/selectLab" id="form1" method="post">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="请输入名称" name="findByName">
                                <span class="input-group-addon btn" onclick="document.getElementById('form1').submit" id="sub">搜索</span>
                            </div>
                        </form>
                        <button class="btn btn-default col-md-2" style="margin-top: 20px" onClick="location.href='/admin/addLab'">
                            添加实验信息
                            <sapn class="glyphicon glyphicon-plus"/>
                        </button>

                    </div>
                </div>
                <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th>id</th>
                        <th>名称</th>
                        <th>号码</th>
                        <th>地址</th>
                        <th>主要内容</th>
                        <th>管理员</th>
                        <th>备注</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach  items="${labList}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.name}</td>
                            <td>${item.number}</td>
                            <td>${item.address}</td>
                            <td>${item.major}</td>
                            <th>${item.admin}</th>
                            <th>${item.outline}</th>
                            <td>
                                <button class="btn btn-default btn-xs btn-info" onClick="location.href='/admin/editLab?id=${item.id}'">修改</button>
                                <button class="btn btn-default btn-xs btn-danger btn-primary" onClick="location.href='/admin/removeLab?id=${item.id}'">删除</button>
                                <!--弹出框-->
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer">
                    <c:if test="${pagingVO != null}">
                        <nav style="text-align: center">
                            <ul class="pagination">
                                <li><a href="/admin/showLab?page=${pagingVO.upPageNo}">&laquo;上一页</a></li>
                                <li class="active"><a href="">${pagingVO.curentPageNo}</a></li>
                                <c:if test="${pagingVO.curentPageNo+1 <= pagingVO.totalCount}">
                                    <li><a href="/admin/showLab?page=${pagingVO.curentPageNo+1}">${pagingVO.curentPageNo+1}</a></li>
                                </c:if>
                                <c:if test="${pagingVO.curentPageNo+2 <= pagingVO.totalCount}">
                                    <li><a href="/admin/showLab?page=${pagingVO.curentPageNo+2}">${pagingVO.curentPageNo+2}</a></li>
                                </c:if>
                                <c:if test="${pagingVO.curentPageNo+3 <= pagingVO.totalCount}">
                                    <li><a href="/admin/showLab?page=${pagingVO.curentPageNo+3}">${pagingVO.curentPageNo+3}</a></li>
                                </c:if>
                                <c:if test="${pagingVO.curentPageNo+4 <= pagingVO.totalCount}">
                                    <li><a href="/admin/showLab?page=${pagingVO.curentPageNo+4}">${pagingVO.curentPageNo+4}</a></li>
                                </c:if>
                                <li><a href="/admin/showLab?page=${pagingVO.totalCount}">最后一页&raquo;</a></li>
                            </ul>
                        </nav>
                    </c:if>
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
<script type="text/javascript">

    function confirmd() {
        var msg = "您真的确定要删除吗？！";
        if (confirm(msg)==true){
            return true;
        }else{
            return false;
        }
    }

</script>
</html>
