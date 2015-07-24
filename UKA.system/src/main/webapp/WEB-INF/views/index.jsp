<%@page import="hal.tokyo.beans.PostingsBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
    <div class="container">
    <div class="row headline"><!-- Begin Headline -->
     	<!-- Slider Carousel
        ================================================== -->
        <div class="span8">
        <c:forEach items="${random}" var="random">
            <a href="http://localhost:8080/UKA.system/detail?post_id=<c:out value="${random.post_id}" />">
            <div class="top_project">
                <div class="top_graph">
                    <input type="text" class="knob" value="<c:out value="${random.achievement_percentage}" />" data-width="240" data-height="240" data-fgColor="#3c8dbc" data-readonly="true"/>
                </div>
                <div class="top_box">
                    <div class="top_user"><!-- top user -->
                        <div class="col-sm-12">
                            <div class="col-xs-4 col-sm-3">
                                <img src="<c:out value="${random.image}" />" alt="user image." />
                            </div>
                            <div class="col-xs-4 col-sm-9 user_comment">
                                <span><c:out value="${random.department_name}" /> : <c:out value="${random.name}" /></span><br/>
                                <c:out value="${random.profilecomment}" />
                            </div>
                        </div>
                    </div><!-- /top user -->

                    <div class="top_info"><!-- top info -->
                        <div class="col-sm-6"><i class="fa fa-calendar"></i>残り期間:<span><c:out value="${random.timelimit}" /></span>日</div>
                        <div class="col-sm-6"><i class="fa fa-male"></i><span><c:out value="${random.achievement_vote}" /></span>人が評価しています。</div>
                    </div><!-- /top info -->
                </div>
            </div>
            </a>
        </div>

        <!-- Headline Text
        ================================================== -->
        <div class="span3 margin-left20">
        	<h3><c:out value="${random.title}" /></h3>
        	<form action="adminTransition" method="post">
		<input type="submit" name="adtransubmit" value="トップへ戻る">
		</form>
            <p class="lead">
                <c:out value="${random.posting_content}" />
            </p>
        </div>
    </div>
    </c:forEach>
    <!-- End Headline -->

    <div class="row gallery-row"><!-- Begin Gallery Row -->

    	<div class="span12">
            <h5 class="title-bg">プロジェクト一覧</h5>

        <!-- Gallery Thumbnails
        ================================================== -->

            <div class="row clearfix no-margin">
            <ul class="gallery-post-grid holder">

                    <!-- Gallery Item 1 -->
                    <c:forEach items="${result}" var="item">
                    <a href="http://localhost:8080/UKA.system/detail?post_id=<c:out value="${item.post_id}" />"><li  class="span3 gallery-item" data-id="id-1" data-type="illustration">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h3 class="panel-title">
                                    <c:out value="${item.title}" />
                                </h3>
                            </div>
                            <div class="panel-body">
                                <div class="row user_info">
                                  <div class="col-sm-12">
                                      <div class="col-xs-4 col-sm-3">
                                          <img src="https://s3.amazonaws.com/uifaces/faces/twitter/adhamdannaway/128.jpg" alt="user image." />
                                      </div>
                                      <div class="col-xs-4 col-sm-9 user_comment">
                                          <span><c:out value="${item.department_name}" /> : <c:out value="${item.name}" /></span><br/>
                                          <c:out value="${item.profilecomment}" />
                                      </div>
                                  </div>
                                </div>
                                <div class="text-center">
                                    <input type="text" class="knob" value="<c:out value="${item.achievement_percentage}" />" data-width="120" data-height="120" data-fgColor="#3c8dbc" data-readonly="true"/>
                                    <div class="knob-label">
                                        <i class="fa fa-calendar"></i><span>残り期間:<c:out value="${item.timelimit}" />日</span>
                                    </div>
                                    <div class="knob-label">
                                        <i class="fa fa-male"></i><span><c:out value="${item.achievement_vote}" />人が評価しています。</span>
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
