<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>メール返信</title>
</head>
<body>
	<h1>詳細・メール作成</h1>
	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="トップへ戻る">
	</form>
	<br />
	<br />
	<br />
	<h2>メール詳細</h2>

	<h3>送信者名</h3>
	<p>
		安威 卯江雄
		<!--送信者名-->
	</p>
	<h3>件名</h3>
	<p>
		なんか眠い気がするんですけど
		<!--件名-->
	</p>
	<h3>本文</h3>
	<p>
		眠い眠い眠い眠い<br />眠い眠い眠い眠い<br />眠い眠い眠い眠い<br />気がする...
		<!--本文-->
	</p>
	<h3>送信日時</h3>
	<p>
		1919/07/21-07:21:48
		<!--送信日時-->
	</p>
	<br />
	<br />
	<br />

	<h2>送信内容作成</h2>
	<form action="" method="post">
		<h3>件名</h3>
		<input type="text">
		<h3>本文</h3>
		<textarea name="msg" cols=40 rows=4>
  		</textarea>
		<br />
		<br />
		<br /> <input type="submit" value="メールを送信">
	</form>
	<br />
	<br />
	<br />
	<br />
	<br />
	<br />
</body>
</html>