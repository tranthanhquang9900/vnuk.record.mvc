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
			
			<tr  class="my-tr-red">
				<td>${myContact.name}</td>
				
				<td>
					<c:if test="${not empty myContact.email}">
						<a href="mailto:${myContact.email}">${myContact.email}</a>
					</c:if>
					
					<c:if test="${empty myContact.email}">
						<i>E-mail has not been given</i>
					</c:if>
				</td>
				
				<td>${myContact.address}</td>
				
				<td>
					<fmt:formatDate value="${myContact.dateOfBirth.time}" pattern="dd/MM/yyyy" />
				</td>
				
				<td>
					<a href="mvc?action=contact.Index" class="btn btn-xs btn-success" id = "return"> Return</a>
					<a href="mvc?action=contact.Update&id=${myContact.id}" class="btn btn-xs btn-success" id = "update">Update</a>				
				</td>
						
			</tr>
		</table>
		
		<c:import url="footer.jsp" />
	</body>
</html>