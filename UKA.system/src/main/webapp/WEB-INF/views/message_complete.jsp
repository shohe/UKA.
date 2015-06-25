<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/css/message.css" />">
<div class="container">
<div class="row headline"><!-- Begin Headline -->
    <div class="top_project_search">
        <div class="top">メッセージ送信完了</div>
        <form class="form-inline" method="get" action="index.htm">
        <div class="messageTable">
            <table>
                <tr><td>
                    メッセージ送信が完了しました。<br/>ありがとうございます。<br/><br/>
                    頂いたメッセージを元にこれからもUKA.が良いシステムである様に努めていきます。
                </td></tr>
                <tr><td><button type="submit" class="btn btn-primary">トップページへ戻る。</button></td></tr>
            </table>
        </div>
        </form>
    </div>
</div><!-- End Headline -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
