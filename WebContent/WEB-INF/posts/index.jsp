<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.monprojetJson.posts.Post" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>posts</title>
</head>
<body>
<h1>Posts</h1>
<ul>
	<% Post post= (Post) request.getAttribute("post"); %>
</ul>
</body>
</html>