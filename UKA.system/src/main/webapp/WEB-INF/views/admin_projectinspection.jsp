<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h1>プロジェクト一覧</h1>
<br />
<br />
<br />
<br />
<br />
<!-- 期限が過ぎているものなどに色をつけたいなー -->
<table class="table" style="table-layout: fixed; word-break: break-all;">
	<tr>
		<th>タイトル</th>
		<th>投稿者名</th>
		<th>投稿日</th>
		<!-- ↓ボタン -->
		<th>詳細</th>
		<!-- ↓ボタン×２　※すでにジャッチが行われている場合はその結果と変更する際のボタンを設置 -->
		<th>ジャッジ</th>
		<!-- ↓ボタン -->
		<th>メール作成</th>
	</tr>

	<!-- ↓jspでがんばるとこ -->
	<c:forEach items="${result}" var="result">
		<tr class="hov_css">
			<td><c:out value="${result.title}" /></td>
			<td><c:out value="${result.name}" /></td>
			<td><c:out value="${result.date}" /></td>
			<td>
				<form action="Adimn" method="post">
					<input type="submit" class="btn btn-danger" name="" value="詳細ボタン">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="150">
				<form action="project_ok" method="post">
					<input type="submit" class="btn btn-danger" name="project_ok" value="採用">
					<input type="hidden" name="title" value="${result.title}">
				</form>
				<form action="project_no" method="post">
					<input type="submit" class="btn btn-danger" name="project_no" value="保留">
					<input type="hidden" name="title" value="${result.title}">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" width="200">
				<form action="adminTransition" method="post">
					<input type="submit" class="btn btn-danger" name="adtransubmit" value="メール作成">
				</form>
			</td>
		</tr>
	</c:forEach>
	<!-- ↑jspでがんばるとこ -->

</table>

<%@ include file="/WEB-INF/views/admin_footer.jsp"%>