package com.sapient.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class SapientEmailService {


	public void sendEmail(String from, String to, String subject, String text) {
	 
		String htmlBodyForResetPassword = "<h1>Auto Communications Service</h1>"
				+ "<p>Hi,\r\n"
				+ "\r\n"
				+ "A password reset for your account was requested.\r\n"
				+ "\r\n"
				+ "Please click the link below to change your password.\r\n"
				+ "\r\n"
				+ "Note that this link is valid for 24 hours. After the time limit has expired, you will have to resubmit the request for a password reset.</p>"
				+ "<br>"
				+ "<p>"+ text + "</p>";

		String htmlBodyForSuccessfulRegistration = "<h1>Auto Communications Service</h1>"
				+ "<p>Hi,\r\n"
				+ "\r\n"
				+ "A Your ccount is successfully created.\r\n"
				+ "\r\n"
				+ "<br>"
				+ "<p>"+ text + "</p>";
		
		String htmlBody = null;
		
		if(subject.toLowerCase().contains("reset")||subject.toLowerCase().contains("password")) {
			htmlBody = htmlBodyForResetPassword;
		}
		if(subject.toLowerCase().contains("successful")||subject.toLowerCase().contains("registration")) {
			htmlBody = htmlBodyForSuccessfulRegistration;
		}

		try {
			//String CONFIGSET = "ConfigSet";
			String type = "UTF-8";
			AmazonSimpleEmailService client = AmazonSimpleEmailServiceClientBuilder.standard()
					.withRegion(Regions.US_EAST_2).build();
	     
			SendEmailRequest request = new SendEmailRequest()
					.withDestination(new Destination()
						.withToAddresses(to))
						.withMessage(new Message()
						
							.withBody(new Body()
								.withHtml(new Content()
								.withCharset(type)
								.withData(htmlBody))
							
							.withText(new Content()
								.withCharset(type)
								.withData("heyyy")))
											
							.withSubject(new Content()
								.withCharset(type)
								.withData(subject)))
							.withSource(from);
							//.withConfigurationSetName(CONFIGSET);
	      
	      client.sendEmail(request);
	      
	      System.out.println("Email sent!");
	    } catch (Exception ex) {
	      System.out.println("The email was not sent. Error message: " 
	          + ex.getMessage());
	    }
	  }

}
