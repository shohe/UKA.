<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者権限付与</title>
</head>
<body>
	<h1>管理者権限付与</h1>
	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="トップへ戻る">
	</form>
	<br />
	<br />
	<br />

	<!--  -->
	<table border="1">
		<tr>
			<th bgcolor="#EE0000"><font color="#FFFFFF">社員名</font></th>
			<th bgcolor="#EE0000" width="150"><font color="#FFFFFF">部署名</font></th>
			<th bgcolor="#EE0000" width="200"><font color="#FFFFFF">メールアドレス</font></th>
			<!-- ↓ボタン -->
			<th bgcolor="#EE0000"><font color="#FFFFFF">ブロック設定</font></th>
			<!-- ↓ボタン -->
			<th bgcolor="#EE0000"><font color="#FFFFFF">管理者権限付与</font></th>
		</tr>

		<!-- ↓jspでがんばるとこ -->
		<tr>
			<td bgcolor="#FFF" align="left" nowrap>安威 卯江雄</td>
			<td bgcolor="#FFF" align="center" width="150">窓際部署</td>
			<td bgcolor="#FFF" align="right" width="200">fbzoo@nhbe.jp</td>
			<td bgcolor="#FFF" align="center" nowrap>
				<form action="#" method="post">
					<input type="submit" name="" value="ブロックボタン">
				</form>
			</td>
			<td bgcolor="#FFF" align="center" nowrap>
				<form action="#" method="post">
					<input type="submit" name="" value="権限付与・破棄ボタン">
				</form>
			</td>
		</tr>
		<!-- ↑jspでがんばるとこ -->
	</table>
</body>
</html>