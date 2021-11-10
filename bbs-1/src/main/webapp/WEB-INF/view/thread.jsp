<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>投稿画面</title>
<link rel = "stylesheet" type = "text/css" href = "css/thread.css">
<script src= "js/thread.js"></script>
</head>
<body>
	<h1>投稿画面</h1>

	<form method = "post" action = "<c:url value = '/insert'/>" name = "form1" onSubmit = "return check()">
		<div class = "name">
			<label>名前</label>
			<input type = "text" name = "name"><br>
		</div>
		<div class = "div">
			<label>投稿内容</label><br>
		<textarea class = "textarea" rows="8" cols="80" name = "content"></textarea>
		</div>
		<button id = "submit" class = "button" type = "submit">投稿</button>
	</form>
		<table class = "table">
			<tr>
				<th>名前</th>
				<th>投稿内容</th>
				<th>日付</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var = "list" items = "${list}" varStatus = "status" >
			<tr>
				<td><c:out value = "${list.name}"></c:out></td>
				<td><c:out value = "${list.content}"></c:out></td>
				<td><c:out value="${list.post_day}"></c:out></td>
				<td>
					<form method = "post" action = "<c:url value = '/delete' />"> 
						<input type = "hidden"  name = "thread_id"  value = "${list.thread_id}">
						<button type = "submit" name = "delete">削除</button>
					</form>
				</td>
				<td>
					<form method = "get" action = "<c:url value = '/SelectOne' />">
						<input type = "hidden" name = "thread_id" value = "${list.thread_id}">
						<button type = "submit" >編集</button>
					</form>
				</td>
			</tr>
			</c:forEach>
			</table>
		</body>
		</html>
		
		