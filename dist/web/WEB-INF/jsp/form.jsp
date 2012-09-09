<%--
* User form that captures data and submits it to the controller. Also lists existing users in the DB
* Author: Anurag Kapur
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- TODO: move css definition to a .css file and reference it -->
<style type="text/css">
.main {
	width: 800px;
	margin: 0 auto;
	border: 1px solid #999;
	background: white;
}

.form {
	width: 400px;
	margin: 0 auto;
	border: 1px solid #999;
	background: white;
}

.list {
	width: 400px;
	margin: 20px;
	background: white;
}

.even {
	background-color: silver;
}
</style>
<title>User Registration System</title>
</head>

<body style="background: #dadada">
	<div class="main">
		<h1 align="center">User Registration System</h1>
		<hr />
		<div class="form">
			<h3 align="center">Add New User</h3>
			<form:form action="add.htm" commandName="user" method="GET">
				<table>
					<tr>
						<td>Lastname</td>
						<td><form:input path="firstname" /></td>
					</tr>
					<tr>
						<td>Surname</td>
						<td><form:input path="surname" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Add User">
						</td>
					</tr>
				</table>
			</form:form>
		</div>
		<div class="list">
			<h3>List of existing users</h3>
			<c:if test="${fn:length(userList) > 0}">
				<table cellpadding="5">
					<tr class="even">
						<th>Lastname</th>
						<th>Surname</th>
					</tr>
					<c:forEach items="${userList}" var="user" varStatus="status">
						<tr class="<c:if test="${status.count % 2 == 0}">even</c:if>">
							<td>${user.firstname}</td>
							<td>${user.surname}</td>
					</c:forEach>
				</table>
			</c:if>
		</div>
	</div>
</body>
</html>