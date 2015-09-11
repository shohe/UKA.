<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>

<link rel="stylesheet" href="<c:url value="/resources/css/search.css" />">
<div class="container">
<div class="row headline"><!-- Begin Headline -->
    <div class="top_project_search">
        <div class="top">プロジェクトを探す。</div>
        <form class="form-inline" action="search" method="post">
        <div class="middle">
              <div class="form-group">
                <div class="input-group">
                  <div class="input-group-addon"><i class="fa fa-search"></i></div>
                  <input type="text" name ="search" class="form-control" id="inputSerachWord" placeholder="検索する言葉を入力してください。">
                  <input type="hidden" name="searchchar" value="${searchchar}">
                </div>
              </div>
              <button type="submit" id="inputSerachBtn" class="btn btn-primary">検索</button>
        </div>
        <div class="bottom">
            <button class="btn btn-default" type="submit" name="newbtn" value="newbtn">新着順</button>
            <button class="btn btn-default" type="submit" name="popular" value="popular">人気順</button>
            <button class="btn btn-default" type="submit" name="neardeadline" value="neardeadline">締切期限が近い順</button>
            <button class="btn btn-default" type="submit" name="highvote" value="highvote">評価数が高い順</button>
            <button class="btn btn-default" type="submit" name="lowvote" value="lowvote">評価数が低い順</button>
        </div>
        </form>
    </div>
</div><!-- End Headline -->

<div class="row gallery-row"><!-- Begin Gallery Row -->

    <div class="span12">
        <h5 class="title-bg">プロジェクト一覧</h5>

    <!-- Gallery Thumbnails
    ================================================== -->

        <div class="row clearfix no-margin">
        <ul class="gallery-post-grid holder">

                <!-- Gallery Item 1 -->
                <c:forEach items="${result}" var="result">
                <a href="http://localhost:8080/UKA.system/detail?post_id=<c:out value="${result.post_id}" />&vote_flag=0"><li  class="span3 gallery-item" data-id="id-1" data-type="illustration">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <h3 class="panel-title">
                                <c:out value="${result.title}" />
                            </h3>
                        </div>
                        <div class="panel-body">
                            <div class="row user_info">
                              <div class="col-sm-12">
                                  <div class="col-xs-4 col-sm-3">
                                      <img src="<c:out value="${result.image}" />" alt="user image." />
                                  </div>
                                  <div class="col-xs-4 col-sm-9 user_comment">
                                      <span><c:out value="${result.department_name}" /> : <c:out value="${result.name}" /></span><br/>
                                      <c:out value="${result.profilecomment}" />
                                  </div>
                              </div>
                            </div>
                            <div class="text-center">
			                            <c:if test="${result.achievement_percentage  >= 100}">
														     		<input type="text" class="knob" value="100" data-width="120" data-height="120" data-fgColor="#3c8dbc" data-readonly="true"/>
														     </c:if>
														     <c:if test="${result.achievement_percentage < 100}">
														         <input type="text" class="knob" value="${result.achievement_percentage}" data-width="120" data-height="120" data-fgColor="#3c8dbc" data-readonly="true"/>
														     </c:if>

                                <div class="knob-label">
                                    <i class="fa fa-calendar"></i><span>残り期間:<c:out value="${result.timelimit}" />日</span>
                                </div>
                                <div class="knob-label">
                                    <i class="fa fa-male"></i><span><c:out value="${result.possession_vote}" />人が評価しています。</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </li></a>
                </c:forEach>

            </ul>
            </div>
        </div>

</div><!-- End Gallery Row -->
<%@ include file="/WEB-INF/views/footer.jsp" %>
