<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h1>管理者権限付与</h1>
<br />
<br />
<br />
<br />
<br />
<br />
<!--  -->
<table class="table" style="table-layout: fixed; word-break: break-all;">
	<tr>
		<th>社員名</th>
		<th>部署名</th>
		<th>メールアドレス</th>
		<!-- ↓ボタン -->
		<th>ブロック設定</th>
		<!-- ↓ボタン -->
		<th>管理者権限付与</th>
	</tr>

	<!-- ↓jspでがんばるとこ -->
	<c:forEach items="${result}" var="rs">
		<tr>
			<td><c:out value="${rs.name}" /></td>
			<td><c:out value="${rs.department_name}" /></td>
			<td><c:out value="${rs.mailaddress}" /></td>
			<td>
				<form action="blockuser" method="post">
					<input type="hidden" name="status" value="${rs.status}">
					<input type="hidden" name="name" value="${rs.name}">
					<input type="submit" class="btn btn-danger" name="" value="ブロックボタン">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" nowrap>
				<form action="investauth" method="post">
					<input type="hidden" name="status" value="${rs.status}">
					<input type="hidden" name="name" value="${rs.name}">
					<input type="submit" class="btn btn-danger" name=""
						value="権限付与・破棄ボタン">
				</form>
			</td>
		</tr>
	</c:forEach>
	<!-- ↑jspでがんばるとこ -->
</table>
<%@ include file="/WEB-INF/views/admin_footer.jsp"%>