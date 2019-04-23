<%@ page language="java"
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
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
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Address</th>
				<th>Date of birth</th>
				<th>Note</th>
			</tr>
			<c:forEach var="contact" items="${myContacts}" varStatus="index">
				<tr class="my-tr-${index.count % 2 == 0 ? 'red' : 'gold' }">
					<td>${contact.name}</td>
					
					<td>
						<c:if test="${not empty contact.email}">
							<a href="mailto:${contact.email}">${contact.email}</a>
						</c:if>
						
						<c:if test="${empty contact.email}">
							<i>E-mail has not been given</i>
						</c:if>
					</td>
					
					<td>${contact.address}</td>
					
					<td>
						<fmt:formatDate value="${contact.dateOfBirth.time}" pattern="dd/MM/yy" />
					</td>
					
					<td>
					    <a href="mvc?action=contact.Show&id=${contact.id}" class="btn btn-xs btn-default" id="show">Show</a>
					    <a href="mvc?action=contact.Update&id=${contact.id}" class="btn btn-xs btn-success" id = "update">Update</a>
						<a href="mvc?action=contact.Delete&id=${contact.id}" class="btn btn-xs btn-danger">Delete</a>
					</td>
							
				</tr>
			</c:forEach>

		</table>

		<a href="mvc?action=contact.Create" class="btn btn-success">Create a new contact</a>	
		<c:import url="footer.jsp" />
	</body>
</html>