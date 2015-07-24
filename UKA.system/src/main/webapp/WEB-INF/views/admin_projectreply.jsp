<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h2>送信内容作成</h2>
<br />
<br />
<br />
<br />
<br />
<br />
<form action="adtransubmit" method="post">
	<h3>件名</h3>
	<input type="text">
	<h3>本文</h3>
	<textarea name="msg" cols=40 rows=4>
  		</textarea>
	<br /> <br /> <br /> <input type="submit" value="メールを送信">
</form>
<%@ include file="/WEB-INF/views/admin_footer.jsp"%>