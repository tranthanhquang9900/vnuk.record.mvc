<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	
		<script>
function goBack() {
  window.history.back()
}
</script>
		<link rel="stylesheet" type="text/css" href="css/index.css">
		<link rel="stylesheet"  type="text/css" href="css/jquery-ui.css">
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>
		<link href="bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
		
        <meta charset="UTF-8">
        <title>Updating contacts</title>
    </head>

    <body>
    
    	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
		<%@ taglib tagdir="/WEB-INF/tags" prefix="vnuk" %>
		<c:import url="header.jsp" />
        <h1>Update contacts</h1>

        <form action="updateContact" method="POST">
        	
        	<input type= "hidden" name="id" value="${myContact.id }"/>           
            <vnuk:myNameField name="name" id="name" label="Name"/>
            <vnuk:myNameField name="address" id="address" label="Address"/>
            <vnuk:myNameField name="email" id="email" label="E-mail"/>
            <vnuk:myDateField name="date_of_birth" id="date-of-birth" label="Date of birth"/>
                        
            <input class="btn btn-success" type="submit" value="Update" />
            <input class="btn btn-xs btn-success" id = "return" type="button" value="Cancel" onclick="window.history.back()">
        </form>

        <c:import url="footer.jsp" />
		
</html>