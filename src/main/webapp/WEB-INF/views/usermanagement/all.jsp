<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>User management</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="../sidebar.jsp"%>
		</div>
		<div class="col-sm-10 container">
			<div class="col-sm-3">
				<h2>Users</h2>
			</div>
			<div class="col-sm-4">
				<br>
				<form action="search" method="post">
					<span class="glyphicon glyphicon-search"></span> <input type="text"
						name=name /> <input type="submit" value="Search" />
				</form>
			</div>
			<table class="table table-hover">
				<thead class="thead-inverse">
					<tr>
						<th>Username</th>
						<th>City</th>
						<th>Details</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.username}</td>
							<td>${user.city.name}</td>

							<td><a class="btn btn-default"
								href="${pageContext.request.contextPath}/user/details/${user.id}">Details</a></td>
							<td><a class="btn btn-default"
								href="${pageContext.request.contextPath}/usermanagement/edit/${user.id}">Edit</a></td>
							<td><a class="btn btn-default"
								href="${pageContext.request.contextPath}/usermanagement/delete/${user.id}">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<a class="btn btn-default"
				href="${pageContext.request.contextPath}/usermanagement/add">Add
				a new user</a>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>

</body>
</html>