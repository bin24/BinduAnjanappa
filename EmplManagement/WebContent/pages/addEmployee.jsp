<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Employee</title>
</head>
<body>

<h1>Insert data For Employee</h1>

<sf:form action ="addDetails.obj" method="post" commandName="emp" modelAttribute="emp">
	
	First Name : <sf:input path="firstName"/> <sf:errors path="firstName"/><br/>
	
	Last Name : <sf:input path="lastName"/> <sf:errors path="lastName"/><br/>
	
	Designation : <sf:input path="designation"/> <sf:errors path="designation"/><br/>
	
	Salary : <sf:input path="salary" /><sf:errors path="salary"/><br/>
	
	
	Select Country :
	<sf:select path="country">
		    <sf:options items="${countrySet}" />
	</sf:select>
	
	 
 	<br/>
	
	Select Department
	<sf:select path="id">
			
		    <sf:options items="${dIds}"/>
	
	</sf:select> 
	
	<!-- <select name="deptId">
		<option value="10">10</option>
		<option value="30">20</option>
		<option value="20">30</option>
	</select>
	 -->
	<br/>
	 
	

	<input type="submit" value="Add Details"/>

</sf:form>

</body>
</html>