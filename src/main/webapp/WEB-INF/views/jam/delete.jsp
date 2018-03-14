<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="../sidebar.jsp"%>
		</div>
		<div class="col-sm-10">
			<h2>Delete jam</h2>
			<p>Are you sure you want to delete this jam? This action is irreversible</p>

			<f:form action="../delete" method="post" modelAttribute="jam">
				<f:hidden path="id" />
				<input class="btn btn-danger" type="submit" value="Delete jam" />
			</f:form>
			<f:form action="../all" method="get">
				<input type="submit" value="Cancel" />
			</f:form>

		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>