<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<%@ include file="../header.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Edit jam</title>
<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
	<div class="row">
		<div class="col-sm-2">
			<%@ include file="../sidebar.jsp"%>
		</div>
		<div class="col-sm-10 container">
			<f:form id="edit" action="../edit" method="post" modelAttribute="jam">
				<div>
					Date:
					<f:input path="date" type="date" name="date" />
				</div>
				<div>
					City:
					<f:select path="city.id" items="${cities}" itemLabel="name"
						itemValue="id" />
					<f:errors path="city" cssClass="error" />
				</div>
				<div>
					Place:
					<f:input type="text" path="place" name="place" />
				</div>
				<div>
					Description:
					<f:textarea path="description" name="description" cols="30"
						rows="4" />
				</div>
				<f:hidden path="id" />
				<div>
					<input type="submit" value="Save changes" />
				</div>
				<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> --%>
			</f:form>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jquery.validate.min.js"/>"></script>
	<script type="text/javascript"
		src="<c:url value="/resources/js/jam/edit.js"/>"></script>
	<%@ include file="../footer.jsp"%>

</body>
</html>