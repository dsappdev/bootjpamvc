<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="addAlien">
		Add an Alien:<br>
		<input type="text" name="alienID"><br>
		<input type="text" name="alienName"><br>
		<input type="text" name="tech"><br>
		<input type="submit"><br><br>
	</form>
	<form action="getAlien">
		Find an Alien:<br>
		<input type="text" name="alienID"><br>		
		<input type="submit"><br><br>
	</form>	
	<form action="deleteAlien">
		Remove an Alien:<br>
		<input type="text" name="alienID"><br>
		<input type="submit"><br><br>
	</form>
	
	<%-- This implementation is very simplistic. Would need a way to prevent the ID from being changed --%>
	<form action="updateAlien">
		Update an Alien:<br>
		Enter alien's ID:
		<input type="text" name="alienID"><br>
		Enter alien's new name:
		<input type="text" name="alienName"><br>
		Enter alien's new ability:
		<input type="text" name="tech"><br>
		<input type="submit"><br><br>
	</form>
</body>
</html>