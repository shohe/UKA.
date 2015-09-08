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

<c:forEach var="enq" items="${enquiry}" varStatus="status">
	<c:out value="${enq.enquiry_id}"/>
	<c:out value="${enq.date}"/>
	<c:out value="${enq.user_id}"/>
	<c:out value="${enq.enquiry_type_id}"/>
	<c:out value="${enq.enquiry_content}"/>
	<c:out value="${status.index}"/><br>
</c:forEach>

    </div><!-- End Headline -->
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
