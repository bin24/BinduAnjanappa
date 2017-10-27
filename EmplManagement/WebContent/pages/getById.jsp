<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Get By Id</title>
</head>
<body>

<form action ="getEmplById.obj">

Enter Employee Id 
<select name="id">
	<c:forEach var="id" items="${empIdList}">
		<option value ="${id}">${id}</option>
	</c:forEach>
</select>

	<input type="submit" value="Get Employee By Id" />

</form>

</body>
</html>