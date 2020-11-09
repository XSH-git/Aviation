<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册新用户</title>
</head>
<body>
<form action="registerUser" method="post">
    Username: <input name="username" type="text" >
    <br>
    Password: <input name="password" type="password">
    <br>
    RealName: <input name="realname" type="text">
    <br>
    <%--        sex:<input name="sex" type="radio">
            <br>--%>
    Mobile: <input type="text" name="mobile">
    <br>
    Email: <input type="text" name="email">
    <input type="submit" value="Submit">
</form>
${message}
</body>
</html>