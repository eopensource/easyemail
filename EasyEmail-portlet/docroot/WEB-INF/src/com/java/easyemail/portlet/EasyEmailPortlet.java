package com.java.easyemail.portlet;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import com.liferay.util.bridges.mvc.MVCPortlet;

public class EasyEmailPortlet extends MVCPortlet{

	public void processEmail(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		System.out.println(actionRequest.getParameter("to")+" "+actionRequest.getParameter("emailText"));
	}
	
}
