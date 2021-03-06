<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/header.jsp"%>

<link rel="stylesheet"
	href="<c:url value="/resources/css/message.css" />">
<div class="container">
	<div class="row headline">
		<!-- Begin Headline -->
			<%
			String user_id = (String) session.getAttribute("Name");
			String mail = (String) session.getAttribute("MailAddress");
			System.out.println("1" + user_id);
			System.out.println("2" + mail);
			if(user_id == null){
				out.println("ログインしてから記入して、どうぞ");
			}
		%>
		<div class="top_project_search">
			<div class="top">管理者にメッセージを送る。</div>
			<form class="form-inline" method="post" action="messageConfirm">
			<input type="hidden" name="user_id" value=user_id>
				<div class="messageTable">
					<table>
						<tr>
							<input type="hidden" name="user" value="user_id">
						</tr>
						<tr>
							<td class="table_left">お問い合わせ種別<i class="fa fa-asterisk"></i></td>
						</tr>
						<tr>
							<td><select id="shubetsu" name="enq_id" class="form-control">
									<option value="1">クレーム</option>
									<option value="2">問題報告</option>
									<option value="3">お問い合わせ</option>
									<option value="4">ユーザー報告</option>
									<option value="5">その他</option>
							</select></td>
						</tr>
						<tr>
							<td class="table_left">お問い合わせ件名<i class="fa fa-asterisk"></i></td>
						</tr>
						<tr>
							<td><input type="text" id="kenmei" name="kenmei" maxlength="100"
								class="form-control" placeholder="件名を入力してください。" value="${kenmei}"></td>
						</tr>
						<tr>
							<td>${err_kenmei}</td>
						</tr>
						<tr>
							<td class="table_left">お問い合わせ内容<i class="fa fa-asterisk"></i></td>
						</tr>
						<tr>
							<td><textarea class="form-control" id="naiyou" name="naiyou"
									rows="10" maxlength="1000" placeholder="1000文字まで。" value="${kenmei}"
									onKeyup="
  o=document.getElementById('slen');
  n=this.value.replace(/\s|　/gm,'').length;
  o.value=n;
  o.innerHTML=n;
  o.style.color=(n>100)?'blue':'blue';
  document.getElementById('mes1').innerHTML=(n>1000)?'文字　文字制限を越えています。1000文字以内で入力してください。':'文字';
  document.getElementById('mes2').innerHTML=(n>1000)?'':'　あと'+(1000-n)+'文字です。';
">${naiyou}</textarea>
<tr><td>
 <span id="slen"></span>
<span id="mes1" style="font-size:12px">　</span>
<span id="mes2" style="font-size:12px"></span></td></tr>
						<tr>
							<td>${err_naiyou}</td>
						</tr>
						<tr>
							<td><button type="submit" class="btn btn-primary">確認画面へ</button></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
	<!-- End Headline -->
	<%@ include file="/WEB-INF/views/footer.jsp"%>