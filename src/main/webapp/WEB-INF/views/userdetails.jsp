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

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/taglib/taglib.jsp"%>
<html>
<head>
    <title>Index</title>
    <link href="http://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.mim.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/test.css"/>
    <script src="../js/jquery_3.2.1.js"></script>
</head>
<script type="text/javascript">
</script>
<body>
<p align="center">User Details</p>
<sys:messages content="${message}"/>
<table>
    <thead>
        <tr>
            <td>id</td>
            <td>NAME</td>
            <td>AGE</td>
            <td>GENDER</td>
            <td>create by</td>
            <td>create date</td>
            <td>update by</td>
            <td>update date</td>
            <td>remarks</td>
        </tr>
    </thead>
    <tbody id="userdetail">
            <tr>
                <td>${userdetails.id}</td>
                <td>${userdetails.name}</td>
                <td>${userdetails.age}</td>
                <td>${userdetails.gender}</td>
                <td>${userdetails.createBy}</td>
                <td>${userdetails.createDate}</td>
                <td>${userdetails.updateBy}</td>
                <td>${userdetails.updateDate}</td>
                <td>${userdetails.remarks}</td>
            </tr>
    </tbody>
</table>
<div class="col-md-12 text-center" style="text-align: center">
    <input id="btnBack" class="btn btn-default" type="button" value="返回" onclick="javascript:history.go(-1)">
</div>
</body>
</html>
