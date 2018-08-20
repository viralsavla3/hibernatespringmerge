<%@page import="entity.Feed"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<table align="center" width="50%" border="1" cellspacing="5">
		<tr bgcolor="wheat" border="1">
			<th>Query</th><th>FeedTime</th>< <th>TotalComments</th> 
		</tr>
		<c:forEach items="${Feeds}" var="feed">
		<tr>
			<td><a href="question.do?id=${ feed.feedId}">${ feed.query}</a></td><!-- passes feedid to showQuestion method in controller -->
			<td>${ feed.feedDate }</td>
		 	<td>${ feed.totalCmnts}</td>	 		
		</tr>
		</c:forEach>
	</table>
</body>
</html>