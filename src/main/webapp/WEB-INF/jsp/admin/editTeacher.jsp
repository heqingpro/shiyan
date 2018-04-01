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
					    	<h1 style="text-align: center;">修改教师信息</h1>
						</div>
				    </div>
				    <div class="panel-body">
						<form class="form-horizontal" role="form" action="/admin/editTeacher" id="editfrom" method="post">
							  <div class="form-group">
							    <label for="inputId" class="col-sm-2 control-label">Id</label>
							    <div class="col-sm-10">
							      <input readonly="readonly" type="number" class="form-control" id="inputId" name="id" placeholder="请输入Id" value="${teacher.id}">
							    </div>
							  </div>
							  <div class="form-group">
							    <label for="inputName" class="col-sm-2 control-label">姓名</label>
							    <div class="col-sm-10">
							      <input type="text" class="form-control" id="inputName" name="name" placeholder="请输入姓名" value="${teacher.name}">
							    </div>
							  </div>
							  <div class="form-group">
								<label for="inputPassword" class="col-sm-2 control-label">密码</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputPassword" name="password" placeholder="请输入密码" value="${teacher.password}">
								</div>
							  </div>
							  <div class="form-group">
								<label for="inputSchool" class="col-sm-2 control-label">学校</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="inputSchool" name="school" placeholder="请输入学校" value="${teacher.school}">
								</div>
							  </div>
                              <div class="form-group">
                                <label for="inputNumber" class="col-sm-2 control-label">工号</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control" id="inputNumber" name="number" placeholder="请输入工号" value="${teacher.number}">
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