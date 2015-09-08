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
            <div class="top">確認画面</div>
            <form class="form-inline" method="post" action="regist_insert_con">
            <div class="messageTable">
                <table>
                    <tr><td class="table_left">部署名<i class="fa fa-asterisk" ></i>:&nbsp;&nbsp;<input type="hidden" name="department_Id" value="${department_Id }" >${department_Id}</td></tr>
                    <tr><td class="table_left">名前<i class="fa fa-asterisk" style="margin-right:15px;"></i>:&nbsp;&nbsp;<input type="hidden" name="name" value="${name }" >${name}</td></tr>
                    <tr><td class="table_left">メールアドレス（ID）<i class="fa fa-asterisk"></i>:&nbsp;&nbsp;<input type="hidden" name="mailaddress" value="${mailaddress }"  >${mailaddress }</td></tr>
                    <tr>
                        <td class="table_left">パスワード<i class="fa fa-asterisk"></i>:&nbsp;&nbsp;<input type="hidden" name="password" value="${password }" >${password_a }
                        <%  %>
                        <!--
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                            <i class="fa fa-asterisk" style="font-size:10px;color:#444;margin:0;"></i>
                       -->
                        </td>
                    </tr>
                    <tr><td class="table_left">サムネイル画像:</td></tr>
                    <tr><td style="padding-left:25px;">
                        <img style="width:100px;height:100px;overflow:hidden;border:3px rgb(205, 205, 205) solid;" class="img-circle" src="/UKA.system/${image }" alt="user image." />
                        <input type="hidden" name="image" value="${image }" >
                    </td></tr>
                    <tr><td class="table_left">プロフィールコメント（一言）:&nbsp;&nbsp;<input type="hidden" name="profileComment" value="${profileComment }" >${profileComment }</td></tr>
                    <tr><td style="height:110px;"><button type="submit" class="btn btn-primary">登録する。</button></td></tr>
                </table>
            </div>
            </form>
        </div>
    </div><!-- End Headline -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
