<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="MailCreateServlet" method="get">
ゆーざーID:<br />
<input type="text" name="user_id"/><br />
めーる送信する対象の投稿ID:<br />
<input type="text" name="post_id"/><br />
たいとる(100文字以内です。):<br />
<input type="text" maxlength="100" name="title"/><br />
ないよう(1000文字以内です。):<br />

<textarea name="content" cols="40" maxlength="1000" rows="5" wrap="physical" onKeyup="
  o=document.getElementById('slen');
  n=this.value.replace(/\s|　/gm,'').length;
  o.value=n;
  o.innerHTML=n;
  o.style.color=(n>100)?'red':'blue';
  document.getElementById('mes1').innerHTML=(n>1000)?'文字　文字制限を越えています。1000文字以内で入力してください。':'文字';
  document.getElementById('mes2').innerHTML=(n>1000)?'':'　あと'+(1000-n)+'文字です。';
">
</textarea>
<br /> <span id="slen"></span>
<span id="mes1" style="font-size:12px">　</span>
<span id="mes2" style="font-size:12px"></span>
<br />

<input type="submit" name="insert" value="insert"/>
</form>

</body>
</html>