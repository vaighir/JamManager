<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root xmlns:jsp="http://java.sun.com/JSP/Page" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8" session="false" />
	<jsp:output doctype-root-element="html"
		doctype-public="-//W3C//DTD XHTML 1.0 Transitional//EN"
		doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"
		omit-xml-declaration="true" />
	<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/style.css"/>" />
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">
	
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}">JAM
					MANAGER</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a
					href="${pageContext.request.contextPath}/usermanagement/all">User
						management</a></li>
				<li><a href="${pageContext.request.contextPath}/jam/all">Jams</a></li>
				<li><a href="${pageContext.request.contextPath}/city">Cities</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="${pageContext.request.contextPath}/user/edit"><span
						class="glyphicon glyphicon-user"></span>Edit account</a></li>
				<li><a href="<c:url value="/logout" />"><span
						class="glyphicon glyphicon-log-out"></span>Log out</a></li>
			</ul>
		</div>
	</nav>
</body>
	</html>
</jsp:root>