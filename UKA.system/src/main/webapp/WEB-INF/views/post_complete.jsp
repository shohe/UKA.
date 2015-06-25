<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<!-- Resource
================================================== -->

<link rel="stylesheet" href="<c:url value="/resources/plugins/fileinput/css/fileinput.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/regist.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/search.css" />">
<script src="<c:url value="/resources/plugins/fileinput/js/fileinput.min.js" />" type="text/javascript"></script>

<div class="container">
    <div class="row headline"><!-- Begin Headline -->
        <div class="top_project_search">
            <div class="top">おめでとうございます。<br/>プロジェクトの投稿が完了しました。</div>
            <form class="form-inline" method="post" action="thankYou">
            <div class="bottom" style="margin-top:60px;">
                <button class="btn btn-primary" type="submit" style="color:#fff;width:150px;height:50px;">トップページに戻る。</button>
            </div>
            </form>
        </div>
    </div><!-- End Headline -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
