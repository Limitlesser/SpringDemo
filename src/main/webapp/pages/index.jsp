<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
%>

<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Employee Management</title>
</head>
<body>
<h3>Employee List</h3>
<p><a href="<%=path %>/addEmployeeUI">Add Employee</a></p>
<table border="1" width="70%">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Gender</td>
        <td>Age</td>
        <td>Delete</td>
        <td>Update</td>
    </tr>
    <c:forEach items="${employeeList}" var="user">
        <tr>
            <td>${user.id }</td>
            <td>${user.name }</td>
            <td>${user.gender }</td>
            <td>${user.age }</td>
            <td><a href="<%=path %>/deleteEmployee?id=${user.id }">Delete</a></td>
            <td><a href="<%=path %>/updateEmployeeUI?id=${user.id }">Update</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>