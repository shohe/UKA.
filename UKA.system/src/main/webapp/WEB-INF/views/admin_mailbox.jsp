<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<tr>
			<td>なんか眠い気がするんですけど</td>
			<td>安威 卯江雄</td>
			<td>1919/07/21-07:21:48</td>
			<td>
				<form action="adminTransition" method="post">
					<input type="submit" class="btn btn-danger" name="adtransubmit"
						value="詳細表示・メール作成">
				</form>
			</td>
		</tr>
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