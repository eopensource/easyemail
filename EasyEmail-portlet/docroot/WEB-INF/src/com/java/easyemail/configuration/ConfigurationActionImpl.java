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
		String server = prefs.getValue("server","true");
		String port = prefs.getValue("port","true");
		String username = prefs.getValue("uname","true");
		String password = prefs.getValue("pass","true");
		prefs.setValue("server", server);
		prefs.setValue("port", port);
		prefs.setValue("uname", username);
		prefs.setValue("pass", password);
		prefs.store();
		System.out.println(server+" "+port+" "+username+" "+password);
	}
}
