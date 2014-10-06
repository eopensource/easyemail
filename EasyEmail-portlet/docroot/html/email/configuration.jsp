<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%@include file="/html/init.jsp" %>
<br/>
<liferay-portlet:actionURL portletConfiguration="true" var="configURL"/>
<aui:form action="<%=configURL %>">
<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
<aui:input name="preferences--server--" label="Server" value="<%=portletPreferences.getValue(\"server\", \"true\")%>"/><br/>
<aui:input name="preferences--port--" label="Port" value="<%=portletPreferences.getValue(\"port\", \"true\")%>"/><br/>
<aui:input name="preferences--uname--" label="Username" value="<%=portletPreferences.getValue(\"uname\", \"true\")%>"/><br/>
<aui:input name="preferences--pass--" type="password" label="Password" value="<%=portletPreferences.getValue(\"pass\", \"true\")%>"/><br/>
<aui:button type="submit"></aui:button>
</aui:form>
</body>
</html>