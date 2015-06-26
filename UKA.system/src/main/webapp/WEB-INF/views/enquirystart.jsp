<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="EnquiryCreateServlet" method="post">
ゆーざID:<br />
<input type="text" name="user_id"/><br />
お問い合わせ種別:<br />
<SELECT name="enq">
        <OPTION value="" selected>----</OPTION>
        <OPTION value="1">くれーむ</OPTION>
        <OPTION value="2">あいてどる</OPTION>
        <OPTION value="3">わぁんないっす</OPTION>
      </SELECT>
ないよう:<br />
<input type="text" name="content"/><br />
<input type="submit" name="insert" value="insert"/>
</form>

</body>
</html>