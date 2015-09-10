<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h1>ジャッジ成功</h1>
<br />
<br />
<br />
<br />
<br />
<br />
<h3>プロジェクトのジャッジを行い状態を変更しました。</h3>
<br />
<br />
<form action="adminTransition" method="post">
	<input type="submit" class="btn btn-danger" name="adtransubmit" value="管理者用トップページ">
</form>
<br />
<br />
<br />
<br />
<br />
<br />
<%@ include file="/WEB-INF/views/admin_footer.jsp"%>