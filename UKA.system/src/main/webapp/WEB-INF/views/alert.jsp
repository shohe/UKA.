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
<table>
<c:forEach var="alert" items="${alert}" varStatus="status">
<tr>
<th>タイトル</th>
<th>総like数</th>
</tr>
<tr>
	<td><c:out value="${alert.title}"/></td>
	<td><c:out value="${alert.possesion_Vote}"/></td>
</tr>
</c:forEach>
</table>
    </div><!-- End Headline -->
</div>
<%@ include file="/WEB-INF/views/footer.jsp" %>
