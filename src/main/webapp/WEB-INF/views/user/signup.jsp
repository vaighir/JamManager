<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create new account</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="../sidebar.jsp"%>
		</div>
		<div class="col-sm-10 container">
			<f:form id="signup" action="signup" method="post"
				modelAttribute="user">
				<div>
					Username:
					<f:input path="username" type="text" name="username" />
				</div>
				<div>
					Email:
					<f:input type="email" path="email" name="email" />
				</div>
				<div>
					Password:
					<f:input type="password" path="password" name="password" />
					Repeat password: <input type="password" name="password2" />
				</div>
				<div>
					<input type="submit" value="Sign up" />
				</div>
				<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
			</f:form>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/user/signup.js"/>"></script>
	<%@ include file="../footer.jsp"%>

</body>
</html>