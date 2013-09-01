<%@page import="org.springperu.curso.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Clientes</title>
</head>
<body>

	<h1>Lista de Clientes</h1>
	<ul>
		<c:forEach var="customer" items="{customers}">
			<li>
				<c:out value="{customer.name}"></c:out>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
