<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>Login</title>
    <style>.error{color:red;}</style>
</head>
<body>

<div class="error">${error}</div>
<form action="<%=path %>/login" method="post">
    Name：<input type="text" name="name"><br/>
    Password：<input type="password" name="password"><br/>
    <input type="submit" value="Login">
</form>

</body>
</html>