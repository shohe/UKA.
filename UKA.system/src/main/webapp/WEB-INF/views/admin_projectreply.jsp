<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UKA.</title>
</head>
<body>
	<h2>送信内容作成</h2>
	<form action="adtransubmit" method="post">
		<h3>件名</h3>
		<input type="text">
		<h3>本文</h3>
		<textarea name="msg" cols=40 rows=4>
  		</textarea>
		<br />
		<br />
		<br /> <input type="submit" value="メールを送信">
	</form>
</body>
</html>