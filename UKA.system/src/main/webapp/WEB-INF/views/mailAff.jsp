<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="MailCreateServlet" method="post">
<input type="hidden" name=user_id value="${user_id}">ユーザID:${user_id}<br />
<input type="hidden" name=post_id value="${post_id}">投稿ID:${post_id}<br />
<input type="hidden" name=title value="${title}">タイトル:【${title}】<br />
<input type="hidden" name=content value="${content}">内容:${content}<br />
これでいいすか<br />
<input type="submit" name="insert" value="そうしん"/>
</form>
</body>
</html>