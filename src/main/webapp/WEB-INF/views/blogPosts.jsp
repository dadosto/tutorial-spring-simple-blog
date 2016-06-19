<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>SimpleBlog</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/style.css" />">
</head>
<body>
	<h1>Blog Posts</h1>
	<div>${logged-in}</div>
	<c:forEach items="${blogPostList}" var="blogPost">
		<li id="blogPost_<c:out value="${blogPost.id}"/>">
		<a href="<c:url value="/showBlogPost"> 
				<c:param name="blogPostId" value="${blogPost.id}"/>
			</c:url> ">
				<div class="blogPostMessage">
					<c:out value="${blogPost.content}" />
					<c:out value="${blogPost.loggedIn}" />
				</div>
				<div>
					<span class="blogPostTime"><c:out
							value="${blogPost.dateTime}" /></span> <span class="blogPostLocation">
						(<c:out value="${blogPost.latitude}" />, <c:out
							value="${blogPost.longitude}" />)
					</span>
				</div>
		</a></li>
	</c:forEach>
</body>
</html>