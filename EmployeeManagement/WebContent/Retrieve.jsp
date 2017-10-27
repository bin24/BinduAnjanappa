<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table>
			<tr><th>#</th><th>CustID</th><th>CustName</th><th>Mobile</th><th>Email</th><th>DOB</th></tr>
			<c:forEach var="item" items="${id}">
				<tr>
					<td>${item.customerId}</td>
					<td>${item.customerName}</td>
					<td>${item.customerMobile}</td>
					<td>${item.customerEmail}</td>
					<td>${item.customerDob}</td>
					
				</tr> 
			</c:forEach>
		</table>
		
		<table>
			
			<%-- <c:forEach var="item" items="${k}"> --%>
				<tr>
					<td>${key.customerId}</td>
					<td>${key.customerName}</td>
					<td>${key.customerMobile}</td>
					<td>${key.customerEmail}</td>
					<td>${key.customerDob}</td>
					
				</tr> 
			<%-- </c:forEach> --%>
		</table>
</body>
</html>