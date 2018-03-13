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
					<th>Date</th>
					<th>City</th>
					<th>Place</th>
					<th>Details</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<c:forEach items="${jams}" var="jam">
					<tr>
						<td>${jam.date}</td>
						<td>${jam.city.name}</td>
						<td>${jam.place}</td>
						
						<td><a href="${pageContext.request.contextPath}/jam/${jam.id}">Details</a></td>
						<td><a href="${pageContext.request.contextPath}/jam/edit/${jam.id}">Edit</a></td>
						<td><a href="${pageContext.request.contextPath}/jam/delete/${jam.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
  			<a  href="${pageContext.request.contextPath}/jam/add">Add a new jam</a>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>


</body>
</html>