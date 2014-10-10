<%@ include file="/html/init.jsp"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-ui:error key="error-key" message="Enter all the values in configuration." />
<liferay-ui:success key="success" message="Message sent successfully." />
<liferay-ui:error key="error-key1" message="Enter value for all the fields below." />
<liferay-portlet:actionURL name="processEmail" var="emailURL"/>
<aui:form action="<%=emailURL%>" method="post">
<aui:input name="to" label="To"/><br/>
<aui:input name="subject" label="Subject"/><br/>
<aui:input name="emailText" type="textarea" label="Email Text"/><br/>
<aui:button type="submit" value="Send"></aui:button>
</aui:form>
<div style="font-family:serif Times New Roman;text-transform: uppercase;text-decoration: underline;font-size: 5">Note</div>
<div style="font-family:serif Times New Roman;font-size: 5">Please make sure if the sender or receiver is a GMail account to enable less secure apps using below link 
</div>
<div style="font-family:serif Times New Roman;font-size: 5">
<a style="text-decoration: none;" href="https://www.google.com/settings/security/lesssecureapps">Enable less secure Apps</a>
</div>