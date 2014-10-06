<%@ include file="/html/init.jsp"%>

<liferay-portlet:actionURL name="processEmail" var="emailURL"/>
<aui:form action="<%=emailURL%>" method="post">
<aui:input name="to" label="To"/><br/>
<aui:input name="emailText" label="Email Text"/><br/>
<aui:button type="submit"></aui:button>
</aui:form>