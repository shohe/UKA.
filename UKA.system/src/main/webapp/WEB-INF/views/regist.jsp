<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- Resource
================================================== -->

<link rel="stylesheet" href="<c:url value="/resources/plugins/fileinput/css/fileinput.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/regist.css" />">
<script src="<c:url value="/resources/plugins/fileinput/js/fileinput.min.js" />" type="text/javascript"></script>

<div class="container">
<div class="row headline"><!-- Begin Headline -->
    <div class="top_project_search">
        <div class="top">新規登録</div>
        <form class="form-inline" method="post" action="RegistModel">
        <div class="messageTable">
            <table>
                <tr><td class="table_left">部署名<i class="fa fa-asterisk"></i></td></tr>
                <tr><td>
                    <select id="shubetsu" class="form-control">
                      <option>お選びください。</option>
                      <option>2</option>
                      <option>3</option>
                      <option>4</option>
                      <option>5</option>
                    </select>
                </td></tr>
                <tr><td class="table_left">名前<i class="fa fa-asterisk"></i></td></tr>
                <tr><td><input type="text" id="kenmei" name="name" class="form-control" placeholder="例) 大谷昇平"></td></tr>
                <tr><td class="table_left">メールアドレス（ID）<i class="fa fa-asterisk">&nbsp;&nbsp;弊社ドメインのみ許可。</i></td></tr>
                <tr><td><input type="text" id="kenmei" name="mailaddress" class="form-control" placeholder="例) mail@example.com"></td></tr>
                <tr><td class="table_left">パスワード<i class="fa fa-asterisk"></i></td></tr>
                <tr><td><input type="text" id="kenmei" name="password" class="form-control" placeholder="半角英数字8文字以上16文字以下"></td></tr>
                <tr><td class="table_left">パスワード（確認）<i class="fa fa-asterisk"></i></td></tr>
                <tr><td><input type="text" id="kenmei" class="form-control" placeholder="コピー&amp;ペーストはおやめ下さい。"></td></tr>
                <tr><td class="table_left">サムネイル画像</td></tr>
                <tr><td><input id="file-0a" class="file" type="file" multiple data-min-file-count="0"></td></tr>
                <tr><td class="table_left">プロフィールコメント（一言）</td></tr>
                <tr><td>
                    <textarea class="form-control"  id="naiyou" name="profileComment" rows="10" maxlength="20" placeholder="20文字まで。">よろしくお願い致します。</textarea>
                </td></tr>
                <tr><td><button type="submit" class="btn btn-primary">確認画面へ</button></td></tr>
            </table>
        </div>
        </form>
    </div>
</div><!-- End Headline -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
