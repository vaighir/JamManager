<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../index/header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Users</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="../sidebar.jsp"%>
		</div>
		<div class="col-sm-10 container">
			<h2>Users from ${city.name }</h2>
			<table class="table table-hover">
				<thead class="thead-inverse">
					<tr>
						<th>Username</th>
						<th>Details</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${users}" var="user">
						<tr>
							<td>${user.username}</td>
							<td><a class="btn btn-default"
								href="${pageContext.request.contextPath}/user/details/${user.id}">Details</a></td>
							
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>

</body>
</html>