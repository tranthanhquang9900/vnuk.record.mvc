<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "vn.edu.vnuk.record.mvc.action.contact.Update"
%>

<html>
	<head>
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
	</head>

	<body>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
		<c:import url="header.jsp" />
				
		<h1>Contact ${param.name} successfully updates!</h1>
		<div>
			<a href="mvc?action=contact.Show&id=${Update.id}" class="btn btn-success">
				Return to the SHOW view !
			</a>
		</div>
		<c:import url="footer.jsp" />
		
	</body>
</html>