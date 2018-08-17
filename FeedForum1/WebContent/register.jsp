<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style>
form {
	width: 400px;
}

label {
	float: left;
	width: 150px;
}

input[type=text] {
	float: left;
	width: 200px;
} 

.clear {
	clear: both;
	height: 0;
	line-height: 0;
}

.floatright {
	float: right;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body bgcolor=black text=red>


	<form action="UserController.hola" method="get">
	
	
<h1>Register</h1>
<label for="userid">User Id: <input type="text" name="userid"	id="name" required><br> <br>
<label for="email"> Email id: <input type="text" id="email"	name="email" required><br> <br>
<label for="password"> Password:<input type="password" id="password" name="password" required><br><br>
 
<br> <br> <input type="submit" id="submit"	name="submit" value="Submit">
 <input	type="submit" class="floatright" value="Cancel" /><br class="clear" /></form>
									
</body>
</html>