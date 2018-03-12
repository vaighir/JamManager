<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit account</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
	<h3>Edit user ${user.username }</h3>
	<f:form id="login" action="edit" method="post">
		<div>
			First name:
			<f:input type="text" path="firstName" name="firstName" />
		</div>
		<div>
			Last name:
			<f:input type="text" path="lastName" name="lastName" />
		</div>
		<div>
			Email:
			<f:input type="email" path="email" name="email" />
		</div>
		<div>
			City:
			<f:select path="city.id" items="${cities}" itemLabel="name"
				itemValue="id" />
			<f:errors path="city" cssClass="error" />
		</div>
		<div>
			Instruments:
			<f:select path="instruments" items="${instruments}" multiple="true"
				itemLabel="name" itemValue="id" />
			<f:errors path="instruments" cssClass="error" />
		</div>
		<div>
			Change password: <input type="password" name="password" />
			Confirm new password: <input type="password" name="password2" />
		</div>
		<div>
			WhatsApp:
			<f:input type="text" path="whatsapp" name="whatsapp" />
		</div>
		<div>
			Facebook:
			<f:input type="text" path="fb" name="fb" />
		</div>
		<div>
			GG:
			<f:input type="text" path="gg" name="gg" />
		</div>
		<div>
			<input type="submit" value="Sign up" />
		</div>
		<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
	</f:form>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/user/edit.js"/>"></script>
</body>
</html>