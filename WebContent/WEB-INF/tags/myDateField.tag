<%@ tag language="java" description='My date field' pageEncoding="UTF-8"%>
<%@ attribute name="name" required="true" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>

<div>
	<label for="${id}">${label}</label>
	<input name="${name}" id="${id}">
	<script>$("#${id}").datepicker({dateFormat:'dd/mm/yy'})</script>
</div>