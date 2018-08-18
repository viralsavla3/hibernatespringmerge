
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
label {
	float: left;
	width: 350px;
}

input[type=text] {
	float: left;
	width: 350px;
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
<title>Insert title here</title>
</head>
<body bgcolor=black text=red>

	<form action="forget.do">
		<marquee>
			<h1>ForgetPage</h1>
		</marquee>
		<font>${Invalid}</font>
	<br><br>
		<label for="userId">User ID: <input type="text" id="userId"
			name="userId" required> <br>
		<br> As Security Question:<br>
		<br> <label for="email">Enter your Email ID: <input
				type="email" id="email" name="email" required><br>
			<br> <input type="submit" value="Submit"><br>
	</form>

</body>
</html>

