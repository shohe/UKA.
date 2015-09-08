<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/header.jsp" %>
<link rel="stylesheet" href="<c:url value="/resources/css/info.css" />">
    <div class="container">

        <div class="left_clm">
            <div class="title_c">
                <h2>${title}</h2>
                <div class="sub">
                    <div class="title_sub">カテゴリ</div>
                    <div class="title_sub_s">${date}</div>
                </div>

                <div class="left_infomaion">
                    ${posting_content}
                </div>
            </div>
        </div>
        <div class="right_clm">
            <a href="#"><li  class="span3 gallery-item" data-id="id-1" data-type="illustration">
                <div class="panel panel-primary">
                    <!-- <div class="panel-heading">
                        <h3 class="panel-title">
                            人事の仕事が一括管理できる、人事システムを作ろう！
                        </h3>
                    </div> -->
                    <div class="panel-body">
                        <div class="row user_info">
                          <div class="col-sm-12">
                              <div class="col-xs-4 col-sm-3">
                                  <img src="https://s3.amazonaws.com/uifaces/faces/twitter/adhamdannaway/128.jpg" alt="user image." />
                              </div>
                              <div class="col-xs-4 col-sm-9 user_comment">
                                  <span>${department_name} : ${name}</span><br/>
                                  ${profilecomment}
                              </div>
                          </div>
                        </div>
                        <div class="text-center">
          
                        	 <c:if test="${achievement_percentage  >= 100}">
											     		<input type="text" class="knob" value="100" data-width="120" data-height="120" data-fgColor="#3c8dbc" data-readonly="true"/>
											     </c:if>
											     <c:if test="${achievement_percentage < 100}">
											         <input type="text" class="knob" value="${achievement_percentage}" data-width="120" data-height="120" data-fgColor="#3c8dbc" data-readonly="true"/>
											     </c:if>
                            
                            <div class="knob-label">
                                <i class="fa fa-male"></i><span>${possession_vote}人が評価しています。</span>
                            </div>
                            <c:if test ="${vote_flag == 1}" >
                            <a class="btn btn-primary" disabled="disabled">気になる！</a>
                            </c:if>
                            <c:if test ="${!(vote_flag == 1)}" >
                            <a class="btn btn-primary" href="detail?post_id=${post_id}&vote_flag=1">気になる！</a>
                            </c:if>
                        </div>
                    </div>
                </div>
            </li></a>
        </div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
