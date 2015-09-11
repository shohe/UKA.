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
		<th>投稿ID</th>
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
			<td><c:out value="${result.post_id}" /></td>
			<td>


					<a href="http://localhost:8080/UKA.system/detail?post_id=<c:out value="${result.post_id}" />&vote_flag=0" class="btn btn-danger">詳細ボタン</a>

			</td>
			<td bgcolor="#FFF" align="center" width="150">
				<c:choose>
					<c:when test="${result.is_permit==0}">
						<form action="project_ok" method="post">
							<input type="submit" class="btn btn-danger" name="project_ok" value="採用">
							<input type="hidden" name="postId" value="${result.post_id}">
						</form>
						<form action="project_no" method="post">
							<input type="submit" class="btn btn-success" name="project_no" value="保留">
							<input type="hidden" name="postId" value="${result.post_id}">
						</form>
					</c:when>
					<c:when test="${result.is_permit=='2'}">
						<form action="project_ok" method="post">
							<input type="submit" class="btn btn-danger" name="project_ok" value="採用">
							<input type="hidden" name="postId" value="${result.post_id}">
						</form>
					</c:when>
					<c:when test="${result.is_permit=='3'}">
						<form action="project_end" method="post">
							<input type="submit" class="btn btn-primary" name="project_ok" value="実施完了">
							<input type="hidden" name="postId" value="${result.post_id}">
						</form>
					</c:when>
					<c:when test="${result.is_permit=='1'}">
						<p>実施終了</p>
					</c:when>
					<c:otherwise>
						どのwhenの判定式もtrueでなかった場合に実行される処理
					</c:otherwise>
			</c:choose>
			</td>
			<td bgcolor="#FFF" align="center" width="200">
				<form action="AdminProjectMail" method="post">
					<input type="submit" class="btn btn-danger" name="admin_mailcreate" value="メール作成">
					<input type="hidden" name="name" value="${result.name}">
					<input type="hidden" name="mailaddress" value="${result.mailaddress}">
				</form>
			</td>
		</tr>
	</c:forEach>
	<!-- ↑jspでがんばるとこ -->

</table>

<%@ include file="/WEB-INF/views/admin_footer.jsp"%>