<%--
  Created by IntelliJ IDEA.
  User: zhou.peng
  Date: 2021/4/14
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%--引用JSTL标签--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/WEB-INF/views/taglib/taglib.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师信息</title>
    <%--引入bootstrap--%>
    <link href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="../js/jquery_3.2.1.js"></script>
</head>
<script type="text/javascript">
</script>
<body>
    <div class="container">
        <div class="row clearfix">
            <div class="page-header">
                <h1 align="center">
                    <small>教师信息</small>
                </h1>
            </div>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-hover table-striped" >
                <thead>
                <tr>
                    <td>id</td>
                    <td>NAME</td>
                    <td>AGE</td>
                    <td>GENDER</td>
                    <td>PHONE</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="teacher" items="${list}">
                    <tr>
                        <td>${teacher.id}</td>
                        <td>${teacher.name}</td>
                        <td>${teacher.age}</td>
                        <td>${teacher.gender}</td>
                        <td>${teacher.phone}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <a href="${ctx}/addTeacher" style="text-decoration:none">新增</a>
        </div>
    </div>

</body>
</html>
