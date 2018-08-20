<%@page import="entity.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1 align="center">FeedForum- Community of Experts</h1>
	<%
		User user = (User) session.getAttribute("User");
		if (user != null) {
			
	%>
	<span> Hello <%=user.getUserId()%> |
	</span>
	<span><a href="dashboard.jsp">Home</a> | <a href="feeds.do">
			Feeds </a> |<a href="logout.do">Logout</a></span>

	<%
		} else {
	%>
		<span>Hello There | <a href="home.jsp">Home</a> </span>
	<%
		}
	%>
	<span style="text-align: right">
		<form action="search.do">
			<input name="keyword"><input type="submit" value="Search">
		</form>
	</span>
	<hr size="3" color="midnightblue">
</body>
</html>