<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
%>

<html>
<head>
    <title>update Employee</title>
</head>

<body>
<form action="<%=path %>/updateEmployee" method="POST">
    <input type="hidden" name="id" value="${employee.id }">
    <table>
        <tr>
            <td> name:</td>
            <td><input type="text" name="name" value="${employee.name }"></td>
        </tr>
        <tr>
            <td> age:</td>
            <td><input type="text" name="age" value="${employee.age }"></td>
        </tr>
        <tr>
            <td> gender:</td>
            <td><input type="text" name="gender" value="${employee.gender }"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Update"></td>
            <td><input type="reset" value="Reset"></td>
        </tr>
    </table>
</form>
</body>
</html>
