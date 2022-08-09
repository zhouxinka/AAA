<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/taglib/taglib.jsp"%>
<%@ attribute name="content" type="java.lang.String" required="true" description="消息内容"%>
<%@ attribute name="type" type="java.lang.String" description="消息类型：info、success、warning、danger、loading"%>
<c:if test="${not empty content}">
    <c:if test="${not empty type}"><c:set var="ctype" value="${type}"/></c:if><c:if test="${empty type}"><c:set var="ctype" value="${fn:indexOf(content,'失败') eq -1?'success':'danger'}"/></c:if>
    <div id="messageBox" class="alert alert-${ctype} hide"><button data-dismiss="alert" class="close">×</button>${content}</div>
</c:if>