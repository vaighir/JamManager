<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../index/header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Log into Jam Manager</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="../index/sidebar.jsp"%>
		</div>
		<div class="col-sm-10 container">
			<form id="login" action="login" method="post">
				<div>
					Username: <input type="text" name="username" />
				</div>
				<div>
					Password: <input type="password" name="password" />
				</div>
				<div>
					<input type="submit" value="Log in" />
				</div>
				<p>Not a user yet?</p>

				<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
			</form>
			<form action="${pageContext.request.contextPath}/user/signup">
				<button type="submit">Sign up!</button>
			</form>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/user/login.js"/>"></script>
	<%@ include file="../footer.jsp"%>

</body>
</html>