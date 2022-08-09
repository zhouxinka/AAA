<%--
  Created by IntelliJ IDEA.
  User: zhou.peng
  Date: 2021/4/14
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/taglib/taglib.jsp"%>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" type="text/css" href="../css/test.css"/>
    <script type="text/javascript" src="../js/jquery_3.2.1.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<p align="center">首页</p>
<a href="${ctx}/userInfo" style="text-decoration:none">查看用户信息</a>
<a href="${ctx}/userInfo_2" style="text-decoration:none">查看用户信息-2</a>
<a href="${ctx}/teacherInfo" style="text-decoration:none">查看教师信息</a>
<a href="${ctx}/testJSP" style="text-decoration:none">测试按钮</a>
<a href="${ctx}/testHttpClientWithGet?name=zhangsan&age=35" style="text-decoration: none">get请求</a>
<a href="${ctx}/testPost" style="text-decoration: none">测试post请求</a>
<a href="" style="text-decoration: none">测试post2请求</a>
</body>
</html>
