<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		<c:import url="header.jsp" />
		<h1>Contact successfully deleted!</h1>
		<a href="mvc?action=contact.Index" class="btn btn-success">Return to INDEX view</a>
		<c:import url="footer.jsp" />
	</body>
</html>