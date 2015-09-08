<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h1>メール一覧</h1>
<br />
<br />
<br />
<br />
<br />
<br />
<div class="admin_main_contents">
	<!-- 読んだものとそうでないものの色分け -->
	<table class="table"
		style="table-layout: fixed; word-break: break-all;">
		<tr>
			<th>件名</th>
			<th>送信者名</th>
			<th>送信日時</th>
			<!-- ↓ボタン -->
			<th>詳細とメール作成</th>
		</tr>

		<!-- ↓jspでがんばるとこ -->
		<c:forEach var="mailbox" items="${mailbox}" varStatus="status">
		<tr>
			<td><c:out value="${mailbox.enquiry_title}"/></td>
			<td><c:out value="${mailbox.user_id}"/></td>
			<td><c:out value="${mailbox.date}"/></td>
			<td>
				<form action="AdminMailReplysReturn" method="post">
				<input type="hidden" name="enquiry_id" value="${mailbox.enquiry_id}">
					<input type="submit" name="AdminMailReplyServlet" value="メールの詳細を確認">
				</form>
			</td>
		</tr>
		</c:forEach>
		<!-- ↑jspでがんばるとこ -->
	</table>
</div>
<br />
<br />
<br />
<br />
<br />
<br />

<%@ include file="/WEB-INF/views/admin_footer.jsp"%>