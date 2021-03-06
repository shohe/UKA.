<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/plugins/fileinput/css/fileinput.css" />">
<link rel="stylesheet" href="<c:url value="/resources/css/post.css" />">
<script src="<c:url value="/resources/js/post.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/plugins/fileinput/js/fileinput.min.js" />" type="text/javascript"></script>




    <div class="container">
    <%
	if(session.getAttribute("Status") == "true"){
%>
<form action="postDetail" method="get">
<input type="submit" name="detail" value="詳細投稿へ遷移">
</form>

        <div class="row">
			<form role="form" action="postSummary" method="post" enctype="multipart/form-data">
            <div class="col-lg-8" id="form-group">

            	<div class="well" id="boxA-title">
                    <h4>プロジェクトタイトル</h4>
						<input type="text" name="maintitle" class="form-control" placeholder="100文字まで..." maxlength="100">
                </div>

                <div class="well" id="boxA-discription">
                    <h4>企画概要</h4>
                        <div class="form-group">
							<textarea name="text[]" placeholder="1000文字まで..." class="form-control" rows="8" maxlength="1000" class="count_me" onKeyup="
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
                        </div>
                        <div class="count"><span>1000</span></div>
                        <input id="file-0a" name="file[]" class="file" type="file" multiple data-min-file-count="0">
                        <input type="hidden" name="title[]" value="企画概要" />
                </div>

            </div>


            <div class="col-md-4">
                <div class="well">
                        <div class="input-group">
                            <div class="input-group"><button type="submit" class="btn btn-warning button-w-max" id="preview">プレビュー</button></div>
                            <div class="input-group"><button type="submit" class="btn btn-primary button-w-max">概要を投稿する。</button></div>
                        </div>
                </div>
            </div>

			</form>

        </div>
        <%
	}else{
		out.println("<br /><br /><br /><br /><br /><h2>ログインしていない状態では投稿することができません。<br />ログインした状態で再度アクセスしてください。</h2><br /><br /><br /><br />");
	}

%>
    </div>

        <!-- /.row -->
<%@ include file="/WEB-INF/views/footer.jsp" %>