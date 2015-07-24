<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h1>送信完了</h1>
<br />
<br />
<br />
<br />
<br />
<br />
<h1>メール送信完了しました。</h1>
<br />
<br />
<form action="adminTransition" method="post">
	<input type="submit" name="adtransubmit" class="btn btn-danger"
		value="トップへ戻る">
</form>

<%@ include file="/WEB-INF/views/admin_footer.jsp"%>