<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin_header.jsp"%>
<h1>詳細・メール作成</h1>
<br />
<br />
<br />
<br />
<br />
<br />
<br />
<h2>メール詳細</h2>
<div class="admin_mail">
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
</div>
<br />
<br />
<br />
<h2>送信内容作成</h2>
<div class="repmail">
	<form action="" method="post">
		<h3>件名</h3>
		<input type="text">
		<h3>本文</h3>
		<textarea name="msg" cols=40 rows=4>
  		</textarea>
		<br /> <br /> <br /> <input type="submit" class="btn btn-danger"
			value="メールを送信">
	</form>
</div>
<br />
<br />
<br />
<br />
<br />
<br />

<%@ include file="/WEB-INF/views/admin_footer.jsp"%>