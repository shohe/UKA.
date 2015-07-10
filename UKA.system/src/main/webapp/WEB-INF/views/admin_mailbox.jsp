<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メール一覧</title>
</head>
<body>
	<h1>メール一覧</h1>
	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="トップへ戻る">
	</form>
	<br />
	<br />
	<br />

	<!-- 読んだものとそうでないものの色分け -->
	<table border="1">
		<tr>
			<th bgcolor="#EE0000"><font color="#FFFFFF">件名</font></th>
			<th bgcolor="#EE0000" width="150"><font color="#FFFFFF">送信者名</font></th>
			<th bgcolor="#EE0000" width="200"><font color="#FFFFFF">送信日時</font></th>
			<!-- ↓ボタン -->
			<th bgcolor="#EE0000"><font color="#FFFFFF">詳細とメール作成</font></th>
		</tr>

		<!-- ↓jspでがんばるとこ -->
		<tr>
			<td bgcolor="#FFF" align="left" nowrap>なんか眠い気がするんですけど</td>
			<td bgcolor="#FFF" align="center" width="150">安威 卯江雄</td>
			<td bgcolor="#FFF" align="right" width="200">1919/07/21-07:21:48</td>
			<td bgcolor="#FFF" align="center" nowrap>
				<form action="adminTransition" method="post">
					<input type="submit" name="adtransubmit" value="詳細表示・メール作成">
				</form>
			</td>
		</tr>
		<!-- ↑jspでがんばるとこ -->
	</table>
</body>
</html>