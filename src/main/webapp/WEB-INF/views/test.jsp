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
    $(function () {
        //定义一个JS对象
        var dataObject = {};
        dataObject['id'] = 33;
        dataObject['name'] = 'ZhouPeng';
        dataObject['age'] = 28;
        dataObject['gender'] = 'Male';
        alert(dataObject['name']);
        $.ajax({
            url:"${ctx}/testData",
            type:"POST",
            contentType: 'application/json;charset=utf-8',
            //将对象转为JSON
            data:JSON.stringify(dataObject),
            dataType:"JSON",
            success:function (data) {
                console.log("data:"+data);
            }
        })
    })
</script>
<body>
</body>
</html>
