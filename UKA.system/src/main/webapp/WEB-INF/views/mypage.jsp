<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<script type="text/javascript">
$('#myTabs a').click(function (e) {
    e.preventDefault()
    $(this).tab('show')
})
$('#myTabs a[href="#profile"]').tab('show') // Select tab by name
$('#myTabs a:first').tab('show') // Select first tab
$('#myTabs a:last').tab('show') // Select last tab
$('#myTabs li:eq(2) a').tab('show') // Select third tab (0-indexed)
</script>
<link rel="stylesheet" href="css/mypage.css">

<div class="container">

        <!-- ここに内容を書いていく -->
        <div>

          <!-- Nav tabs -->
          <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">プロフィール編集</a></li>
            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">投稿したプロジェクト</a></li>
            <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">管理者からのメール</a></li>
          </ul>

          <!-- Tab panes -->
          <div class="tab-content">
            <div role="tabpanel" class="tab-pane active" id="home">
                <div class="top_project_search">
                    <form class="form-inline" method="get" action="regist_confirm.htm">
                    <div class="messageTable">
                        <table>
                            <tr><td class="table_left">部署名</td></tr>
                            <tr><td>
                                <select id="shubetsu" class="form-control">
                                  <option>お選びください。</option>
                                  <option>2</option>
                                  <option>3</option>
                                  <option>4</option>
                                  <option>5</option>
                                </select>
                            </td></tr>
                            <tr><td class="table_left">名前</td></tr>
                            <tr><td><input type="text" id="kenmei" class="form-control" placeholder="例) 大谷昇平"></td></tr>
                            <tr><td class="table_left">メールアドレス（ID）<i class="fa fa-asterisk">&nbsp;&nbsp;弊社ドメインのみ許可。</i></td></tr>
                            <tr><td><input type="text" id="kenmei" class="form-control" placeholder="例) mail@example.com"></td></tr>
                            <tr><td class="table_left">現在のパスワード</td></tr>
                            <tr><td><input type="text" id="kenmei" class="form-control" placeholder="半角英数字8文字以上16文字以下"></td></tr>
                            <tr><td class="table_left">新しいパスワード</td></tr>
                            <tr><td><input type="text" id="kenmei" class="form-control" placeholder="コピー&amp;ペーストはおやめ下さい。"></td></tr>
                            <tr><td class="table_left">サムネイル画像</td></tr>
                            <tr><td><input id="file-0a" class="file" type="file" multiple data-min-file-count="0"></td></tr>
                            <tr><td class="table_left">プロフィールコメント（一言）</td></tr>
                            <tr><td>
                                <textarea class="form-control"  id="naiyou"　rows="10" maxlength="20" placeholder="20文字まで。">よろしくお願い致します。</textarea>
                            </td></tr>
                            <tr><td><button type="submit" class="btn btn-primary">確認画面へ</button></td></tr>
                        </table>
                    </div>
                    </form>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="profile">

<!--
プロジェクトがなれけば下１行のコメントアウトを外す。
-->
        <!-- 現在、あなたが投稿したプロジェクトはありません。 -->
            <div class="panel panel-default">
          <!-- Default panel contents -->
          <!-- Small modal -->
<!--
プロジェクトがあればテーブルを表示する。
-->
              <div class="panel-heading">投稿したプロジェクト一覧</div>
          <!-- Table -->
              <table class="table">
                <tr>
                    <th>投稿日付</th>
                    <th>プロジェクトタイトル</th>
                    <th>評価数</th>
                    <th>ステータス</th>
                </tr>
                <tr class="hov_css">
                    <td>2015-07-03</td>
                    <td>伝説のポートレイトレンズ・Petzvalをボケ調節機能を備えた58mmレンズに！</td>
                    <td>78</td>
                    <td>概要</td>
                </tr>
                <tr class="info hov_css">
                    <td>2015-07-03</td>
                    <td>伝説のポートレイトレンズ・Petzvalをボケ調節機能を備えた58mmレンズに！</td>
                    <td>78</td>
                    <td>詳細</td>
                </tr>
                <tr class="hov_css">
                    <td>2015-07-03</td>
                    <td>伝説のポートレイトレンズ・Petzvalをボケ調節機能を備えた58mmレンズに！</td>
                    <td>78</td>
                    <td>概要</td>
                </tr>
                <tr class="hov_css">
                    <td>2015-07-03</td>
                    <td>伝説のポートレイトレンズ・Petzvalをボケ調節機能を備えた58mmレンズに！</td>
                    <td>78</td>
                    <td>概要</td>
                </tr>
                <tr class="active hov_css">
                    <td>2015-07-03</td>
                    <td>伝説のポートレイトレンズ・Petzvalをボケ調節機能を備えた58mmレンズに！</td>
                    <td>78</td>
                    <td>破棄</td>
                </tr>
              </table>
            </div>
        </div>
        <div role="tabpanel" class="tab-pane" id="messages">
<!--
プロジェクトがなれけば下１行のコメントアウトを外す。
-->
        <!-- 現在、あなたが投稿したプロジェクトはありません。 -->
        <div class="panel panel-default">
          <!-- 返信用 -->
          <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                  <h4 class="modal-title" id="myLargeModalLabel">返信をする</h4>
                </div>
                <div class="modal-body">
                    <form class="" action="#" method="post">
                        <h4>タイトル</h4>
                        <input type="text" class="form-control" placeholder="タイトル" /><br/>
                        <h4>内容</h4>
                        <textarea class="form-control" rows="10" placeholder="内容"></textarea><br/>
                        <button type="submit" class="btn btn-default" style="margin-left:810px;">送信</button>
                    </form>
                </div>
              </div>
            </div>
          </div>

		  <!-- メール確認用 -->
          <div class="modal fade bs-example-modal-op" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
            <div class="modal-dialog modal-lg">
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                  <h4 class="modal-title" id="myLargeModalLabel">メール内容</h4>
                </div>
                <div class="modal-body">
                    <form class="" action="#" method="post">
                        <h4>タイトル</h4>
                        <input type="text" class="form-control" placeholder="タイトル" /><br/>
                        <h4>内容</h4>
                        <textarea class="form-control" rows="10" placeholder="内容"></textarea><br/>
                    </form>
                </div>
              </div>
            </div>
          </div>
<!--
プロジェクトがあればテーブルを表示する。
-->
          <div class="panel-heading">管理者からのメッセージ一覧</div>
          <!-- Table -->
          <table class="table">
            <tr>
                <th>投稿日付</th>
                <th>メールタイトル</th>
				<th>メールを開く</th>
                <th>返信する</th>
            </tr>
            <c:forEach items="${adminMailsViewData}" var="adminMailsViewItem">
            <tr class="hov_css">
                <td>${adminMailsViewItem.date}</td>
                <td>${adminMailsViewItem.title}</td>
				<td>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-op">開く</button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">返信</button>
                </td>
            </tr>
            </c:forEach>
          </table>
        </div>
    </div>
  </div>

</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>