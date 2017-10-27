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
<form action="retrieveID.obj">
<table>
	<tr>
			<td>Customer Id: &nbsp;&nbsp;</td>
			<td>			
					 <select  name="customerId">
					<c:forEach items="${k}" var="list">
						<option value="${list}"><c:out value="${list}" /></option>
					</c:forEach> 

    				 </select>
						
			</td>
		</tr>
		<tr >
		<td colspan="2" align="center">
		<input  class="btn" type="submit" value="Submit" >
		</td>
		</tr>
		</table>
		</form>
</body>

</html>