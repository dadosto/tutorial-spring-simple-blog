<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>SimpleBlog</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Simple Blog</h1>
	<div>${logged-in}</div>
	<a href="<c:url value="/blogposts" />">Blog posts</a> |
	<a href="<c:url value="/blog/register" />">Sign-Up</a>
</body>
</html>