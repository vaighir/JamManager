<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Jam manager</title>
</head>
<body>
  <h2>Access denied</h2>
  <a href="${pageContext.request.contextPath}">Return to index</a><br>
			<img src="<c:url value="resources/img/access-denied.jpg" />" />
</body>
</html>