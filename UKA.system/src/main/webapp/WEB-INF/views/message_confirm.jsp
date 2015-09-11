<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/css/message.css" />">
<div class="container">
<div class="row headline"><!-- Begin Headline -->
    <div class="top_project_search">
        <div class="top">メッセージ確認</div>
        <form class="form-inline" method="post" action="EnquiryCreateServlet">
        <div class="messageTable">
        <% //System.out.println("2" + ${enq_name}); %>
            <table>
                <tr><td>お問い合わせ種別名</td></tr>
                <tr><td><input type="hidden" name=enq_id value="${enq_id}">${enq_name}</td></tr>
                <tr><td>お問い合わせ件名</td></tr>
                <tr><td><input type="hidden" name=kenmei value="${kenmei}">${kenmei}</td></tr>
                <tr><td>お問い合わせ内容</td></tr>
                <tr><td><input type="hidden" name=naiyou value="${naiyou}">${naiyou}</td></tr>
                <tr><td><button type="submit" class="btn btn-primary">送信する。</button></td></tr>
            </table>
        </div>
        </form>
    </div>
</div><!-- End Headline -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
