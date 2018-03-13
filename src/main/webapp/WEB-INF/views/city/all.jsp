<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All jams</title>
</head>
<body>

	<div class="row">
		<div class="col-sm-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-sm-10">
			<h2>Jams</h2>
			<table>
				<tr>
					<th>Name</th>
					<th>Users</th>
					<th>Jams</th>
				</tr>

				<c:forEach items="${cities}" var="city">
					<tr>
						<td>${city.name}</td>
						
						<td><a href="${pageContext.request.contextPath}/city/${city.id}/users">Users</a></td>
						<td><a href="${pageContext.request.contextPath}/city/${city.id}/jams">Jams</a></td>
					</tr>
				</c:forEach>
			</table>
  			<a  href="${pageContext.request.contextPath}/jam/add">Add a new jam</a>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>


</body>
</html>