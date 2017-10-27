<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>All Data</h2> <span> | </span> <a href="../index.obj">Home Page</a>
<c:forEach items="${list}" var="elist">
<c:out value="---------------------------"></c:out><br/>
<c:out value="${elist.custId}"><br/></c:out><br/>
<c:out value="${elist.name}"><br/></c:out><br/>
<c:out value="${elist.quantity}"><br/></c:out><br/>
Action ::: <a href="edit.obj?customerId=${elist.custId}">EDIT</a> <span>|</span>
			<a href="delete.obj?customerId=${elist.custId}">DELETE</a>
</c:forEach>
</body>
</html>