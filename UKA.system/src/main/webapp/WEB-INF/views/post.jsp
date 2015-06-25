<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/plugins/fileinput/css/fileinput.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/post.css" />">
<script src="<c:url value="/resources/js/post.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/plugins/fileinput/js/fileinput.min.js" />" type="text/javascript"></script>

    <div class="container">

        <div class="row">
			<form role="form" action="post" method="post" enctype="multipart/form-data">
            <div class="col-lg-8" id="form-group">
            	<div class="well" id="boxA-title">
                    <h4>プロジェクトタイトル</h4>
						<input type="text" name="title" class="form-control" placeholder="100文字まで...">
                </div>
                
                <div class="well" id="boxA-background">
                    <h4>背景</h4>

                        <div class="form-group">
                            <textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me"></textarea>
                        </div>
                        <div class="count"><span>1000</span></div>
                        <input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0">
                        <input type="hidden" name="title[]" value="背景" />
                </div>

                <div class="well" id="boxA-parpus">
                    <h4>企画の目的</h4>
                        <div class="form-group">
                            <textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me"></textarea>
                        </div>
                        <div class="count"><span>1000</span></div>
                        <input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0">
                        <input type="hidden" name="title[]" value="企画の目的" />
                </div>

                <div class="well" id="boxA-target">
                    <h4>ターゲット</h4>
                        <div class="form-group">
                            <textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me"></textarea>
                        </div>
                        <div class="count"><span>1000</span></div>
                        <input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0">
                        <input type="hidden" name="title[]" value="ターゲット" />
                </div>

                <div class="well" id="boxA-search">
                    <h4>市場調査</h4>
                        <div class="form-group">
                            <textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me"></textarea>
                        </div>
                        <div class="count"><span>1000</span></div>
                        <input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0">
                        <input type="hidden" name="title[]" value="市場調査" />
                </div>

                <div class="well" id="boxA-discription">
                    <h4>企画概要</h4>
                        <div class="form-group">
                            <textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me"></textarea>
                        </div>
                        <div class="count"><span>1000</span></div>
                        <input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0">
                        <input type="hidden" name="title[]" value="企画概要" />
                </div>

                <div class="well" id="boxA-plan">
                    <h4>収支計画</h4>
                        <div class="form-group">
                            <textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me"></textarea>
                        </div>
                        <div class="count"><span>1000</span></div>
						<input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0">
						<input type="hidden" name="title[]" value="収支計画" />
                </div>
            </div>


            <div class="col-md-4">
                <div class="well">
                        <div class="input-group">
                            <div class="input-group">
                                <table>
                                    <tr>
                                        <td><label><input type="checkbox" id="box-background" name="check-disc[]" value="background" checked>背景</label></td>
                                        <td><label><input type="checkbox" id="box-parpus" name="check-disc[]" value="parpus" checked>企画の目的</label></td>
                                        <td><label><input type="checkbox" id="box-target" name="check-disc[]" value="target" checked>ターゲット</label></td>
                                    </tr>
                                    <tr>
                                        <td><label><input type="checkbox" id="box-search" name="check-disc[]" value="search" checked>市場調査</label></td>
                                        <td><label><input type="checkbox" id="box-discription" name="check-disc[]" value="discription" checked>企画概要</label></td>
                                        <td><label><input type="checkbox" id="box-plan" name="check-disc[]" value="plan" checked>収支計画</label></td>
                                    </tr>
                                </table>

                            </div>
                            <div class="input-group komoku">
                                <form class="form-inline" id="komoku-form">
                                    <div class="col-sm-3 komoku3"><a class="btn btn-primary" id="plus" role="button" onclick="add();">項目追加</a></div>
                                    <div class="col-sm-9"><input type="text" class="form-control" name="komoku-name" placeholder="項目名を入力してください。"></div>
                                </form>
                            </div>
                            <div class="input-group"><button type="submit" class="btn btn-warning button-w-max" id="preview">プレビュー</button></div>
                            <div class="input-group"><button type="submit" class="btn btn-primary button-w-max">概要を投稿する。</button></div>
                        </div>
                </div>
            </div>
			</form>

        </div>
        <!-- /.row -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
