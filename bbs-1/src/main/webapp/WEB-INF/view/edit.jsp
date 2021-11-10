<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>編集画面</title>
</head>
<body>
<h1>投稿編集画面</h1>

	<a href = "/bbs-1/home">投稿画面へ</a>

	<form method = "post" action="<c:url value = '/update' />">
		<input type = "hidden" name = "thread_id" value = "${thread.thread_id}">
		<label>名前</label><br>
		<input type = "text" name = "name" ><br>
		<label>投稿内容</label><br>
		<textarea name = "content"></textarea><br>
		<button type = "submit" name = "update">更新</button>
		
	</form>

</body>
</html>