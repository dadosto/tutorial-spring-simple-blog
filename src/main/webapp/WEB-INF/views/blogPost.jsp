<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Blog Post</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<div>${logged-in}</div>
	<div>
		<h1>
			<c:out value="${blogPost.title}" />
		</h1>
		<c:out value="${blogPost.id}" />
		<div class="blogPostMessage">
			<c:out value="${blogPost.content}" />
			<c:out value="${blogPost.loggedIn}" />
		</div>
		<div>
			<span class="blogPostTime"><c:out value="${blogPost.dateTime}" /></span>
			<span class="blogPostLocation"> (<c:out
					value="${blogPost.latitude}" />, <c:out
					value="${blogPost.longitude}" />)
			</span>
		</div>
	</div>
</body>
</html>