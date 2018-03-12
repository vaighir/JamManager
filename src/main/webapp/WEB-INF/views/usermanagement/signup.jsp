<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create new account</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
  <form id="login" action="signup" method="post">
    <div>
      Username: <input type="text" name="username"/>
    </div>
    <div>
      Email: <input type="email" name="email"/>
    </div>
    <div>
      Password: <input type="password" name="password"/>
      Repeat password: <input type="password" name="password2"/>
    </div>
    <div>
      <input type="submit" value="Sign up"/>
    </div>
    <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
  </form>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/user/signup.js"/>"></script>
</body>
</html>