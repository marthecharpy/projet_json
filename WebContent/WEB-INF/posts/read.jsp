<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.monprojetJson.posts.Post" %>
<% Post post = (Post) request.getAttribute("post"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= post.getTitle() %></title>
</head>
<body>

<a href="<%= request.getContextPath() %>/posts">Back to posts</a>

<h1><%= post.getTitle() %></h1>
<p><%= post.getContent() %></p>
</body>
</html>