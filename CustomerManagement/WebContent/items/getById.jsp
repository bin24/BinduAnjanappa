<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <form action ="getCustById.obj">
 <table>
 <tr>
 <td>
	Enter Customer Id <!-- <input type="text" name ="custId"/><br/> -->
	<select name="id">
	<c:forEach var="id" items="${empIdList}">
		<option value ="${id}">${id}</option>
	</c:forEach>
</select>
</tr>
<tr>
<td>
	<input type="submit" value="Get Customer By Id" /></td>
	</table>
</form>
</body>
</html>
