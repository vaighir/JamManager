<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>"/>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
			integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
			crossorigin="anonymous">
	</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="${pageContext.request.contextPath}">JAM MANAGER</a>
	    </div>
	    <ul class="nav navbar-nav">
	      <li><a href="${pageContext.request.contextPath}/usermanagement">Users</a></li>
	      <li><a href="${pageContext.request.contextPath}/jams">Jams</a></li>
	      <li><a href="${pageContext.request.contextPath}/cities">Cities</a></li>
	    </ul>
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="signup"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
	      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    </ul>
	  </div>
	</nav>

</body>
</html>