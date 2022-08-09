<%--
  Created by IntelliJ IDEA.
  User: zhou.peng
  Date: 2021/4/16
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/views/taglib/taglib.jsp"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery_3.2.1.js"></script>
    <script type="text/javascript">

    </script>
</head>
<body>
<body>
<sys:messages content="${message}"/>
    <form action="${ctx}/doLogin" method="post">
        username:<br>
        <input type="text" name="username"><br>
        password:<br>
        <input type="password" name="password"><br><br>
        <input type="submit" value="login">
    </form>
</body>
</body>
</html>
