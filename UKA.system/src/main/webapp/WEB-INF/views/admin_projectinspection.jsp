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
	<tr class="hov_css">
		<td>玉子とベーコンとクリームソースのパスタをみんなで作り続けるaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</td>
		<td>安威 卯江雄</td>
		<td>1919/07/21-07:21:48</td>
		<td>
			<form action="#" method="post">
				<input type="submit" class="btn btn-danger" name="" value="詳細ボタン">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="150">
			<form action="#" method="post">
				<input type="submit" class="btn btn-danger" name="" value="採用">
				<input type="submit" class="btn btn-danger" name="" value="保留">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="200">
			<form action="#" method="post">
				<input type="submit" class="btn btn-danger" name="" value="メール作成">
			</form>
		</td>
	</tr>
	<!-- ↑jspでがんばるとこ -->

	<tr class="hov_css">
		<td>玉子とベーコンとクリームソースのパスタをみんなで食べ続ける</td>
		<td>安威 卯江雄</td>
		<td>1919/07/21-07:21:48</td>
		<td>
			<form action="#" method="post">
				<input type="submit" name="" value="詳細ボタン">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="150">
			<form action="#" method="post">
				<input type="submit" name="" value="採用"> <input
					type="submit" name="" value="保留">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="200">
			<form action="#" method="post">
				<input type="submit" name="" value="メール作成">
			</form>
		</td>
	</tr>

	<tr class="hov_css">
		<td>玉子とベーコンとクリームソースのパスタをみんなで巻き続ける</td>
		<td>安威 卯江雄</td>
		<td>1919/07/21-07:21:48</td>
		<td>
			<form action="#" method="post">
				<input type="submit" name="" value="詳細ボタン">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="150">
			<form action="#" method="post">
				<input type="submit" name="" value="採用"> <input
					type="submit" name="" value="保留">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="200">
			<form action="#" method="post">
				<input type="submit" name="" value="メール作成">
			</form>
		</td>
	</tr>

	<tr class="hov_css">
		<td>玉子とベーコンとクリームソースのパスタをみんなでゆで続ける</td>
		<td>安威 卯江雄</td>
		<td>1919/07/21-07:21:48</td>
		<td>
			<form action="#" method="post">
				<input type="submit" name="" value="詳細ボタン">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="150">
			<form action="#" method="post">
				<input type="submit" name="" value="採用"> <input
					type="submit" name="" value="保留">
			</form>
		</td>
		<td bgcolor="#FFF" align="center" width="200">
			<form action="#" method="post">
				<input type="submit" name="" value="メール作成">
			</form>
		</td>
	</tr>
</table>

<%@ include file="/WEB-INF/views/admin_footer.jsp"%>