package com.java.easyemail.portlet;

import java.io.IOException;

import javax.mail.internet.MimeMessage.RecipientType;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;

import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class EasyEmailPortlet extends MVCPortlet{

	public void processEmail(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		PortletPreferences prefs = actionRequest.getPreferences();
		String server = prefs.getValue("server","");
		String port = prefs.getValue("port","");
		String username = prefs.getValue("uname","");
		String password = prefs.getValue("pass","");
		String to = actionRequest.getParameter("to");
		String subject = actionRequest.getParameter("subject");
		String emailText = actionRequest.getParameter("emailText");
		
		if(server.isEmpty() || port.isEmpty() || username.isEmpty() || password.isEmpty()){
			SessionErrors.add(actionRequest, "error-key");
		} else if(to.isEmpty() || emailText.isEmpty() || subject.isEmpty()) {
			SessionErrors.add(actionRequest, "error-key1");
		} else {
			final Email email = new Email();
			email.setFromAddress("",String.valueOf(prefs.getValue("uname", "")));
			email.setSubject(actionRequest.getParameter("subject"));
			email.addRecipient("", actionRequest.getParameter("to"), RecipientType.TO);
			email.setText(actionRequest.getParameter("emailText"));
			
			try{
				new Mailer(server, Integer.valueOf(port), username, password,TransportStrategy.SMTP_TLS).sendMail(email);
				SessionMessages.add(actionRequest, "success");
			} catch (Exception e) {
				SessionErrors.add(actionRequest, "lesssecureapps");
			}
		}
	}
	
}
