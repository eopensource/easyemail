package com.java.easyemail.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		super.processAction(portletConfig, actionRequest, actionResponse);
		PortletPreferences prefs = actionRequest.getPreferences();
		String server = prefs.getValue("server","");
		String port = prefs.getValue("port","");
		String username = prefs.getValue("uname","");
		String password = prefs.getValue("pass","");
		prefs.setValue("server", server);
		prefs.setValue("port", port);
		prefs.setValue("uname", username);
		prefs.setValue("pass", password);
		prefs.store();
	}
}
