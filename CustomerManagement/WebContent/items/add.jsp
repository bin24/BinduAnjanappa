<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insert data For Customer</h1>

<sf:form action ="addDetails.obj" method="post" commandName="cus">
	
	 Name : <sf:input path="name"/> <sf:errors path="name"/><br/>
	
	Quantity : <sf:input path="quantity"/> <sf:errors path="quantity"/><br/>
	
	Select Country :
	<sf:select path="country">
		    <sf:options items="${countrySet}" />
	</sf:select>
	
	<input type="submit" value="Add Details"/>

</sf:form>
</body>
</html>