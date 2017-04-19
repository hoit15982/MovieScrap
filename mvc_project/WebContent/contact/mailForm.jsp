<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바 메일 보내기 폼</title>
</head>
<body>
<form action="mailSend" method="post">
	<ul>
		<li>보내는 사람 : <input type="text" name="sender" /></li>
		<li>받은사람 메일 : <input type="text" name="receiver" /></li>
		<li>제목 : <input type="text" name="subject" /></li>
		<li><textarea name="content" id="content" cols="30" rows="10"></textarea></li>
	</ul>
	<input type="submit" value="보내기" />
</form>
</body>
</html>