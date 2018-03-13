<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jam details</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-sm-10">
			<h1>Jam session</h1>
			<h3>Date</h3>
			<p>${jam.date }</p>

			<h3>City</h3>
			<p>${jam.city.name }</p>

			<h3>Place</h3>
			<p>${jam.place }</p>

			<h3>Founder</h3>
			<p>${jam.founder.username }</p>

			<h3>Description</h3>
			<p>${jam.description }</p>

			<h3>Participants</h3>
			<a href="">Join!</a>


			<h3>Leave a comment</h3>
			<f:form id="comment" action="comment" method="post"
				modelAttribute="comment">
				<div>
					<f:textarea path="text" name="text" cols="30" rows="4" />
				</div>
				<f:hidden path="jam" value="${jam.id}" />
				<div>
					<input type="submit" value="Send" />
				</div>
			</f:form>

			<h3>Comments</h3>
			<c:forEach items="${comments}" var="comment">
				<table>
					<tr>
						<th>${comment.date }</th>
					</tr>
					<tr>
						<td>${comment.text }</td>
					</tr>
					<tr>
						<td>${comment.user }</td>
					</tr>
				</table>
			</c:forEach>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>