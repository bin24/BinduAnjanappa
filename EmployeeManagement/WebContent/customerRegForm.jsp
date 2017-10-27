<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="resForm.obj" method="post" commandName="cust" modelAttribute="cust">
	
	<h1 align="center">Employee management</h1>
	<hr width="66%">
<table align="center" cellpadding="5" border="5" cellsapcing="0">
		
			
			
		
		
		<tr>
			<td>Customer Name: &nbsp;&nbsp;</td>
			<td>			
				<form:input  path="customerName"/><form:errors path="customerName"/>				
			</td>
		</tr>
		
		<tr>
			<td class="right"> Customer Id:&nbsp;&nbsp; </td>
			<td>
				<form:input path="customerId"/><form:errors path="customerId"/>
					
			</td>
			</tr>
		
		<tr>
			<td>Customer Mobile: &nbsp;&nbsp;</td>
			<td>
			<form:input path="customerMobile"/><form:errors path="customerMobile"/>
			</td>
		</tr>
		<tr>
			<td>Customer Email: &nbsp;&nbsp; </td>
			<td>
			<form:input path="customerEmail"/><form:errors path="customerEmail"/>
			</td>
		</tr>
		<tr>
			<td>DOB:&nbsp;&nbsp; </td>
			<td>
			<form:input  path="customerDob"/><form:errors path="customerDob"/>
			</td>
		</tr>
		<tr >
		<td colspan="2" align="center">
		<input  class="btn" type="submit" value="Submit" >
		</td>
		</tr>
		
	</table>
	</form:form>
</body>
</html>