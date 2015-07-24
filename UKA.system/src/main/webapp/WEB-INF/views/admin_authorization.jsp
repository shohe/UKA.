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
	<tr>
		<td>安威 卯江雄</td>
		<td>窓際部署</td>
		<td>fbzoo@nhbe.jp</td>
		<td>
			<form action="#" method="post">
				<input type="submit" class="btn btn-danger" name="" value="ブロックボタン">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" nowrap>
			<form action="#" method="post">
				<input type="submit" class="btn btn-danger" name=""
					value="権限付与・破棄ボタン">
			</form>
		</td>
	</tr>
	<!-- ↑jspでがんばるとこ -->
</table>
<%@ include file="/WEB-INF/views/admin_footer.jsp"%>