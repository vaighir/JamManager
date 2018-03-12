<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Log in to Jam Manager</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
  <form id="login" action="login" method="post">
    <div>
      Username: <input type="text" name="username"/>
    </div>
    <div>
      Password: <input type="password" name="password"/>
    </div>
    <div>
      <input type="submit" value="Log in"/>
    </div>
    <%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
  </form>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
  <script type="text/javascript" src="<c:url value="/resources/js/user/login.js"/>"></script>
</body>
</html>