<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jam Manager</title>
</head>
<body>

	<div class="row">
		<div class="col-sm-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-sm-10 container">
			<h1>Contact details</h1>
			<h3>Why do you want to contact the author?</h3>
			<h4>The app is not working properly</h4>
			<p>It's the servers fault. Do not disturb the author.</p>
			<h4>I can't log in</h4>
			<p>You're typing in the password wrong. Do not disturb the author.</p>
			<h4>I can't sign up</h4>
			<p>You're probably not cool enough. Do not disturb the author.</p>
			<h4>This app is so amazing I just have to hire the author!</h4>
			<p>You have to contact the author!!! You'll find more details on my <a href="https://github.com/vaighir">github</a></p>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>
	
</body>
</html>