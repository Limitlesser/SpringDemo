<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<html>
	<head>
		<title>add Employee</title>
	</head>

	<body>
		<form action="<%=path %>/addEmployee" method="POST">
			<table>
				<tr>
					<td>name:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>gender:</td>
					<td><input type="text" name="gender"></td>
				</tr>
				<tr>
					<td>age:</td>
					<td><input type="number" name="age"></td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Save">
					</td>
					<td>
						<input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
