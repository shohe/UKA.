<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="MailCreateServlet" method="get">
ゆーざーID:<br />
<input type="text" name="user_id"/><br />
めーる送信する対象の投稿ID:<br />
<input type="text" name="post_id"/><br />
たいとる:<br />
<input type="text" name="title"/><br />
ないよう:<br />
<input type="text" name="content"/><br />
<input type="submit" name="insert" value="insert"/>
</form>

</body>
</html>