<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cities</title>
</head>
<body>

	<div class="row">
		<div class="col-sm-2">
			<%@ include file="../sidebar.jsp"%>
		</div>
		<div class="col-sm-10">
			<div class="row">
				<div class="col-sm-3">
					<h2>Cities</h2>
				</div>
				<div class="col-sm-4">
				<br>
					<form action="search" method="post">
						<span class="glyphicon glyphicon-search"></span>
						<input type="text" name=name />
						<input type="submit" value="Search" />
					</form>
				</div>
			</div>

			<table class="table table-hover">
				<thead class="thead-inverse">
					<tr>
						<th>Name</th>
						<th>Users</th>
						<th>Jams</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${cities}" var="city">
						<tr>
							<td><b>${city.name}:</b></td>

							<td><a class="btn btn-default"
								href="${pageContext.request.contextPath}/city/${city.id}/users">Users
									in ${city.name }</a></td>
							<td><a class="btn btn-default"
								href="${pageContext.request.contextPath}/city/${city.id}/jams">Jams
									in ${city.name }</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>


</body>
</html>