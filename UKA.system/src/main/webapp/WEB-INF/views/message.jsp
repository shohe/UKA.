<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/css/message.css" />">
<div class="container">
<div class="row headline"><!-- Begin Headline -->
    <div class="top_project_search">
        <div class="top">管理者にメッセージを送る。</div>
        <form class="form-inline" method="post" action="messageConfirm">
        <div class="messageTable">
            <table>
                <tr><td class="table_left">お問い合わせ種別<i class="fa fa-asterisk"></i></td></tr>
                <tr><td>
                    <select id="shubetsu" class="form-control">
                      <option>お選びください。</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                    </select>
                </td></tr>
                <tr><td class="table_left">お問い合わせ件名<i class="fa fa-asterisk"></i></td></tr>
                <tr><td><input type="text" id="kenmei" class="form-control" placeholder="件名を入力してください。"></td></tr>
                <tr><td class="table_left">お問い合わせ内容<i class="fa fa-asterisk"></i></td></tr>
                <tr><td>
                    <textarea class="form-control"  id="naiyou" rows="10" maxlength="1000" placeholder="1000文字まで。"></textarea>
                </td></tr>
                <tr><td><button type="submit" class="btn btn-primary">確認画面へ</button></td></tr>
            </table>
        </div>
        </form>
    </div>
</div><!-- End Headline -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
