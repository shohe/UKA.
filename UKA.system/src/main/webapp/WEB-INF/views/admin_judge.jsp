<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>プロジェクトジャッジ</title>
</head>
<body>
<h1>プロジェクトのジャッジを受け付けました。</h1>
    <form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="管理者用トップページ">
	</form>
</body>
</html>
<%@ include file="/WEB-INF/views/admin_footer.jsp"%>