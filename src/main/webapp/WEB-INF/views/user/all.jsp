<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All users</title>
</head>
<body>

	<div class="row">
		<div class="col-sm-2">
			<%-- <%@ include file="sidebar.jsp"%> --%>
		</div>
		<div class="col-sm-10">
			<h2>Users list</h2>
			<table class="table table-hover">
				<thead class="thead-inverse">
					<tr>
						<th>Username</th>
						<th>City</th>
						<th>Details</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.username}</td>
							<td>${user.city}</td>

							<td><a href="<c:url value='details?id=${user.id}'/>">Details</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>


</body>
</html>