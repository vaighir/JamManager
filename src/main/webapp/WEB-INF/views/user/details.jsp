<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User details</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-sm-10">
			<h1>User ${user.username }</h1>
			<h3>Name</h3>
			<p>${user.firstName }${user.lastName }</p>

			<h3>City</h3>
			<p>${user.city.name }</p>

			<h3>Instruments</h3>
			<c:forEach items="${user.instruments}" var="instrument">
				<li>${instrument.name }</li>
			</c:forEach>

			<h3>Owned jams</h3>
			<c:forEach items="${user.foundedJams}" var="fj">
				<li>${fj.date } in ${fj.city.name } <a href="${pageContext.request.contextPath}/jam/${fj.id}">Details</a></li>
			</c:forEach>

			<h3>Takes part in</h3>
			<c:forEach items="${user.jams}" var="jam">
				<li>${jam.date } in ${jam.city.name } <a href="${pageContext.request.contextPath}/jam/${jam.id}">Details</a></li>
			</c:forEach>
			<h3>Contact</h3>
			<h4>Email</h4>
			<p>${user.email }</p>

			<h4>WhatsApp</h4>
			<p>${user.whatsapp }</p>
			

		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>