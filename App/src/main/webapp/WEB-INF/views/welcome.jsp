<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HelloWorld page</title>
</head>
<body>
<h1>Spring MVC Tutorials CRUD With Spting 4 , Mysql 5 , AnnontationConfig No XML </h1>

	Greeting : ${greeting} <br/>
	Salary ${employee} <br/>
	ent ${ent}
	
	
	
	<h1>add employee</h1>
	<form:form action="/app/add" commandName="employee" method="GET">
<table>
	
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="false" size="8"  disabled="false" />
			
		</td> 
	</tr>

	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="salary">
				<spring:message text="salary"/>
			</form:label>
		</td>
		<td>
			<form:input path="salary" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty person.name}">
				<input type="submit"
					value="<spring:message text="Edit Person"/>" />
			</c:if>
			<c:if test="${empty person.name}">
				<input type="submit"
					value="<spring:message text="Add Person"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
	
<h1>List employees </h1>	


<h3>Persons List</h3>
<c:if test="${!empty lists}">
	<table class="tg">
	<tr>
		<th width="80">Person ID</th>
		<th width="400">Person Name</th>
		<th width="120">Person salary</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${lists}" var="person">
		<tr>
			<td>${person.id}</td>
			<td>${person.name}</td>
			<td>${person.salary}</td>
			<td><a href="<c:url value='/edit/${person.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${person.id}' />" >Delete</a></td>
			
		</tr>
	</c:forEach>
	</table>
</c:if>
	
	<a href="/app/add/">Add Employee</a>
	
</body>
</html>