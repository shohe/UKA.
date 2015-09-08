<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>

<h1>管理者用トップページ</h1>
<br />
<br />
<br />
<br />
<br />
<br />
<div id="topnavi">
	<form action="adminTransition" method="post">
		<input type="submit" class="btn btn-danger" name="adtransubmit"
			value="プロジェクト一覧">
	</form>
	<br /> <br />
	<form action="adminTransition" method="post">
		<input type="submit" class="btn btn-danger" name="adtransubmit"
			value="メール一覧">
	</form>
	<br /> <br />
	<form action="adminTransition" method="post">
		<input type="submit" class="btn btn-danger" name="adtransubmit"
			value="権限管理">
	</form>
</div>
<%@ include file="/WEB-INF/views/admin_footer.jsp"%>